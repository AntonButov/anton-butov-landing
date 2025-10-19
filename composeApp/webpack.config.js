const path = require('path');
const CompressionPlugin = require('compression-webpack-plugin');
const { BundleAnalyzerPlugin } = require('webpack-bundle-analyzer');

module.exports = (config, options) => {
    // Базовые настройки
    config.mode = options.mode || 'production';
    
    // Оптимизация для продакшена
    if (config.mode === 'production') {
        // Минификация и оптимизация
        config.optimization = {
            ...config.optimization,
            minimize: true,
            splitChunks: {
                chunks: 'all',
                cacheGroups: {
                    vendor: {
                        test: /[\\/]node_modules[\\/]/,
                        name: 'vendors',
                        chunks: 'all',
                        priority: 10,
                        reuseExistingChunk: true,
                    },
                    wasm: {
                        test: /\.wasm$/,
                        name: 'wasm',
                        chunks: 'all',
                        priority: 20,
                        reuseExistingChunk: true,
                    },
                    common: {
                        name: 'common',
                        minChunks: 2,
                        chunks: 'all',
                        priority: 5,
                        reuseExistingChunk: true,
                    }
                }
            },
            usedExports: true,
            sideEffects: false,
        };

        // Добавляем плагины для сжатия
        config.plugins = config.plugins || [];
        
        // Gzip сжатие
        config.plugins.push(
            new CompressionPlugin({
                algorithm: 'gzip',
                test: /\.(js|css|html|svg|wasm)$/,
                threshold: 8192,
                minRatio: 0.8,
                deleteOriginalAssets: false,
            })
        );

        // Brotli сжатие (если доступно)
        try {
            config.plugins.push(
                new CompressionPlugin({
                    filename: '[path][base].br',
                    algorithm: 'brotliCompress',
                    test: /\.(js|css|html|svg|wasm)$/,
                    compressionOptions: {
                        level: 11,
                    },
                    threshold: 8192,
                    minRatio: 0.8,
                    deleteOriginalAssets: false,
                })
            );
        } catch (e) {
            console.warn('Brotli compression not available');
        }

        // Анализ бандла (только в dev режиме)
        if (process.env.ANALYZE_BUNDLE) {
            config.plugins.push(
                new BundleAnalyzerPlugin({
                    analyzerMode: 'static',
                    openAnalyzer: false,
                    reportFilename: '../../build/bundle-analysis.html'
                })
            );
        }
    }

    // Настройки для dev сервера
    if (config.mode === 'development') {
        config.devServer = {
            ...config.devServer,
            compress: true,
            hot: true,
            liveReload: true,
            static: {
                directory: path.join(__dirname, 'src/wasmJsMain/resources'),
                publicPath: '/',
            },
            headers: {
                'Cache-Control': 'no-cache',
                'Cross-Origin-Embedder-Policy': 'require-corp',
                'Cross-Origin-Opener-Policy': 'same-origin',
            },
        };
    }

    // Настройки для всех режимов
    config.resolve = {
        ...config.resolve,
        fallback: {
            ...config.resolve.fallback,
            "fs": false,
            "path": false,
            "crypto": false,
        }
    };

    // Настройки для Wasm
    config.experiments = {
        ...config.experiments,
        asyncWebAssembly: true,
        syncWebAssembly: true,
    };

    // Оптимизация модулей
    config.module = {
        ...config.module,
        rules: [
            ...(config.module?.rules || []),
            {
                test: /\.wasm$/,
                type: 'webassembly/async',
            },
            {
                test: /\.(png|jpe?g|gif|svg|webp)$/i,
                type: 'asset/resource',
                generator: {
                    filename: 'assets/images/[name].[hash][ext]',
                },
            },
            {
                test: /\.(woff|woff2|eot|ttf|otf)$/i,
                type: 'asset/resource',
                generator: {
                    filename: 'assets/fonts/[name].[hash][ext]',
                },
            },
        ],
    };

    // Настройки для производительности
    config.performance = {
        hints: config.mode === 'production' ? 'warning' : false,
        maxEntrypointSize: 512000,
        maxAssetSize: 512000,
    };

    return config;
};




