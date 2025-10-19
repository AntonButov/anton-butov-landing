const CACHE_NAME = 'anton-butov-landing-v1';
const STATIC_CACHE_NAME = 'anton-butov-static-v1';

// Критические ресурсы для кэширования
const CRITICAL_RESOURCES = [
    './',
    './index.html',
    './composeApp.js',
    './vendors.js',
    './styles.css',
    './composeResources/font/Inter-Regular.ttf',
    './composeResources/font/Inter-Medium.ttf',
];

// Ресурсы для кэширования при первом запросе
const RUNTIME_CACHE_PATTERNS = [
    /\.wasm$/,
    /\.js$/,
    /\.css$/,
    /\.ttf$/,
    /\.png$/,
    /\.svg$/,
    /\.jpg$/,
    /\.jpeg$/,
    /\.webp$/,
];

// Установка Service Worker
self.addEventListener('install', (event) => {
    console.log('Service Worker installing...');
    
    event.waitUntil(
        caches.open(STATIC_CACHE_NAME)
            .then((cache) => {
                console.log('Caching critical resources...');
                return cache.addAll(CRITICAL_RESOURCES);
            })
            .then(() => {
                console.log('Critical resources cached successfully');
                // Принудительная активация нового SW
                return self.skipWaiting();
            })
            .catch((error) => {
                console.error('Failed to cache critical resources:', error);
            })
    );
});

// Активация Service Worker
self.addEventListener('activate', (event) => {
    console.log('Service Worker activating...');
    
    event.waitUntil(
        caches.keys()
            .then((cacheNames) => {
                return Promise.all(
                    cacheNames.map((cacheName) => {
                        // Удаляем старые кэши
                        if (cacheName !== CACHE_NAME && cacheName !== STATIC_CACHE_NAME) {
                            console.log('Deleting old cache:', cacheName);
                            return caches.delete(cacheName);
                        }
                    })
                );
            })
            .then(() => {
                console.log('Service Worker activated');
                // Принудительное управление всеми клиентами
                return self.clients.claim();
            })
    );
});

// Обработка запросов
self.addEventListener('fetch', (event) => {
    const { request } = event;
    const url = new URL(request.url);
    
    // Игнорируем не-GET запросы
    if (request.method !== 'GET') {
        return;
    }
    
    // Игнорируем запросы к внешним доменам
    if (url.origin !== location.origin) {
        return;
    }
    
    event.respondWith(
        caches.match(request)
            .then((cachedResponse) => {
                // Если ресурс есть в кэше, возвращаем его
                if (cachedResponse) {
                    console.log('Serving from cache:', request.url);
                    return cachedResponse;
                }
                
                // Иначе загружаем из сети
                return fetch(request)
                    .then((response) => {
                        // Проверяем, что ответ валидный
                        if (!response || response.status !== 200 || response.type !== 'basic') {
                            return response;
                        }
                        
                        // Кэшируем ресурсы, соответствующие паттернам
                        const shouldCache = RUNTIME_CACHE_PATTERNS.some(pattern => 
                            pattern.test(request.url)
                        );
                        
                        if (shouldCache) {
                            console.log('Caching new resource:', request.url);
                            
                            // Клонируем ответ для кэширования
                            const responseToCache = response.clone();
                            
                            caches.open(CACHE_NAME)
                                .then((cache) => {
                                    cache.put(request, responseToCache);
                                });
                        }
                        
                        return response;
                    })
                    .catch((error) => {
                        console.error('Fetch failed:', error);
                        
                        // Для HTML запросов возвращаем кэшированную версию
                        if (request.headers.get('accept').includes('text/html')) {
                            return caches.match('./index.html');
                        }
                        
                        throw error;
                    });
            })
    );
});

// Обработка сообщений от основного потока
self.addEventListener('message', (event) => {
    if (event.data && event.data.type === 'SKIP_WAITING') {
        self.skipWaiting();
    }
});

// Периодическая очистка кэша
self.addEventListener('message', (event) => {
    if (event.data && event.data.type === 'CLEAN_CACHE') {
        event.waitUntil(
            caches.keys().then((cacheNames) => {
                return Promise.all(
                    cacheNames.map((cacheName) => {
                        if (cacheName !== STATIC_CACHE_NAME) {
                            return caches.delete(cacheName);
                        }
                    })
                );
            })
        );
    }
});