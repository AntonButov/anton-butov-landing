# Performance Optimization Guide

This guide explains the optimizations made to improve cold start performance of the Anton Butov portfolio site.

## Implemented Optimizations

### 1. Resource Loading Optimization
- ✅ **Preconnect** to external domains (instead of dns-prefetch) for faster connections
- ✅ **Preload** critical WASM modules (`composeApp.wasm`, `skiko.wasm`)
- ✅ **Inline Critical CSS** - styles needed for initial render are inlined in `<head>`
- ✅ **Async CSS Loading** - non-critical styles load asynchronously
- ✅ **Deferred JSON-LD** - structured data moved to end of body, minified

### 2. JavaScript Optimization
- ✅ **Minified inline scripts** - loading screen logic is compressed
- ✅ **Deferred Service Worker** - registration delayed by 1s to not block initial load
- ✅ **Optimized progress simulation** - lighter code, less memory usage

### 3. Service Worker Improvements
- ✅ **Cache-First Strategy** - instant loading on repeat visits
- ✅ **Background Updates** - cached resources update silently in background
- ✅ **WASM Caching** - WebAssembly modules are aggressively cached
- ✅ **Stale-While-Revalidate** - show cached content, update in background

## Server Configuration (Recommended)

To maximize performance, configure your web server with these settings:

### Apache (.htaccess)

```apache
# Enable compression
<IfModule mod_deflate.c>
    AddOutputFilterByType DEFLATE text/html text/css text/javascript application/javascript application/json
    AddOutputFilterByType DEFLATE application/wasm
</IfModule>

# Enable Brotli compression (if available)
<IfModule mod_brotli.c>
    AddOutputFilterByType BROTLI_COMPRESS text/html text/css text/javascript application/javascript
    AddOutputFilterByType BROTLI_COMPRESS application/wasm
</IfModule>

# Cache control
<IfModule mod_expires.c>
    ExpiresActive On
    
    # WASM files - cache for 1 year
    ExpiresByType application/wasm "access plus 1 year"
    
    # JavaScript and CSS - cache for 1 year
    ExpiresByType application/javascript "access plus 1 year"
    ExpiresByType text/javascript "access plus 1 year"
    ExpiresByType text/css "access plus 1 year"
    
    # HTML - cache for 1 hour
    ExpiresByType text/html "access plus 1 hour"
    
    # Images - cache for 1 month
    ExpiresByType image/png "access plus 1 month"
    ExpiresByType image/svg+xml "access plus 1 month"
</IfModule>

# HTTP/2 Server Push (if available)
<IfModule mod_http2.c>
    H2PushResource add /composeApp.js
    H2PushResource add /composeApp.wasm
    H2PushResource add /skiko.wasm
</IfModule>

# Security headers
<IfModule mod_headers.c>
    # CORS for WASM
    Header set Cross-Origin-Opener-Policy "same-origin"
    Header set Cross-Origin-Embedder-Policy "require-corp"
    
    # Cache control headers
    <FilesMatch "\.(js|wasm)$">
        Header set Cache-Control "public, max-age=31536000, immutable"
    </FilesMatch>
    
    <FilesMatch "\.css$">
        Header set Cache-Control "public, max-age=31536000, immutable"
    </FilesMatch>
    
    <FilesMatch "\.html$">
        Header set Cache-Control "public, max-age=3600, must-revalidate"
    </FilesMatch>
</IfModule>
```

### Nginx

```nginx
# Enable gzip compression
gzip on;
gzip_vary on;
gzip_types text/plain text/css text/javascript application/javascript application/json application/wasm;
gzip_min_length 256;

# Enable Brotli (if available)
brotli on;
brotli_types text/plain text/css text/javascript application/javascript application/json application/wasm;

# Cache control
location ~* \.(wasm|js)$ {
    expires 1y;
    add_header Cache-Control "public, immutable";
}

location ~* \.css$ {
    expires 1y;
    add_header Cache-Control "public, immutable";
}

location ~* \.(png|svg|ico)$ {
    expires 1M;
    add_header Cache-Control "public";
}

location ~* \.html$ {
    expires 1h;
    add_header Cache-Control "public, must-revalidate";
}

# CORS headers for WASM
add_header Cross-Origin-Opener-Policy "same-origin";
add_header Cross-Origin-Embedder-Policy "require-corp";

# HTTP/2 Server Push
location = /index.html {
    http2_push /composeApp.js;
    http2_push /composeApp.wasm;
    http2_push /skiko.wasm;
}
```

### GitHub Pages

For GitHub Pages, create a `_headers` file in your repository root:

```
/*
  Cache-Control: public, max-age=3600
  Cross-Origin-Opener-Policy: same-origin
  Cross-Origin-Embedder-Policy: require-corp

/*.wasm
  Cache-Control: public, max-age=31536000, immutable
  Content-Type: application/wasm

/*.js
  Cache-Control: public, max-age=31536000, immutable

/*.css
  Cache-Control: public, max-age=31536000, immutable
```

Note: GitHub Pages has limited configuration options. Consider using Cloudflare for additional optimization.

## CDN Configuration (Cloudflare)

If using Cloudflare:

1. **Enable Auto Minify** for HTML, CSS, and JavaScript
2. **Enable Brotli Compression**
3. **Enable HTTP/2 & HTTP/3**
4. **Set Page Rules**:
   - `*.wasm` → Cache Level: Cache Everything, Edge Cache TTL: 1 month
   - `*.js` → Cache Level: Cache Everything, Edge Cache TTL: 1 month
5. **Enable Rocket Loader** (optional, test carefully with WASM apps)

## Performance Metrics to Monitor

Use these tools to measure improvements:

- **[PageSpeed Insights](https://pagespeed.web.dev/)** - Overall performance score
- **[WebPageTest](https://www.webpagetest.org/)** - Detailed loading waterfall
- **Chrome DevTools** - Network tab, Performance tab
- **Lighthouse** - Built into Chrome DevTools

### Target Metrics
- **First Contentful Paint (FCP)**: < 1.8s
- **Largest Contentful Paint (LCP)**: < 2.5s
- **Time to Interactive (TTI)**: < 3.8s
- **Total Blocking Time (TBT)**: < 200ms
- **Cumulative Layout Shift (CLS)**: < 0.1

## Additional Optimizations

### Future Improvements
- [ ] Use WebAssembly streaming compilation (`WebAssembly.compileStreaming`)
- [ ] Implement lazy loading for non-critical sections
- [ ] Consider code splitting for large applications
- [ ] Add resource hints for user navigation patterns
- [ ] Implement prefetching for next-page resources
- [ ] Consider using a CDN for static assets

### Build Optimizations
When building your Kotlin/WASM project:

```bash
# Enable production optimizations
./gradlew wasmJsBrowserProductionWebpack

# Additional Gradle settings in gradle.properties:
kotlin.js.compiler=ir
kotlin.native.cacheKind=static
org.gradle.parallel=true
org.gradle.caching=true
```

## Testing Cold Start Performance

1. **Disable cache** in Chrome DevTools (Network tab)
2. **Clear Application cache** (Application tab → Clear storage)
3. **Reload** and measure
4. Compare with cached performance (second reload)

Expected improvements:
- **Cold start**: 20-40% faster initial load
- **Warm start**: 70-90% faster with service worker cache
- **Repeat visits**: Near-instant loading from cache

## Troubleshooting

### WASM not loading
- Check CORS headers are set correctly
- Verify `.wasm` files have correct MIME type
- Check browser console for errors

### Service Worker not caching
- Clear existing service workers
- Check `sw.js` is accessible
- Verify HTTPS is enabled (required for service workers)

### Slow first load
- Enable HTTP/2 on server
- Verify compression is enabled
- Check server response times
- Consider using a CDN

---

**Last Updated**: October 2025  
**Version**: 3.0

