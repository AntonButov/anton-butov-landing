// Service Worker for caching critical resources
const CACHE_NAME = 'anton-butov-v3';
const CRITICAL_RESOURCES = [
    '/',
    '/index.html',
    '/composeApp.js',
    '/styles.css',
    '/favicon-32x32.png',
    '/favicon-16x16.png'
];

// WASM binaries are cached on-demand via the fetch handler to avoid
// duplicating the parallel warmup requests kicked off by index.html.

// Install event - cache critical resources for faster subsequent loads
self.addEventListener('install', (event) => {
    event.waitUntil(
        caches.open(CACHE_NAME)
            .then(cache => cache.addAll(CRITICAL_RESOURCES))
            .catch(() => {}) // Fail silently if offline
            .then(() => self.skipWaiting())
    );
});

// Activate event - clean up old caches
self.addEventListener('activate', (event) => {
    event.waitUntil(
        caches.keys().then((cacheNames) => {
            return Promise.all(
                cacheNames.map((cacheName) => {
                    if (cacheName !== CACHE_NAME) {
                        return caches.delete(cacheName);
                    }
                })
            );
        }).then(() => {
            return self.clients.claim();
        })
    );
});

// Fetch event - Cache First strategy for better performance
self.addEventListener('fetch', (event) => {
    // Only handle GET requests
    if (event.request.method !== 'GET') return;

    // Skip cross-origin requests
    if (!event.request.url.startsWith(self.location.origin)) return;

    // Cache First strategy: Try cache first, then network
    event.respondWith(
        caches.match(event.request).then((cachedResponse) => {
            if (cachedResponse) {
                // Return cached version immediately
                // Update cache in background for next time
                fetch(event.request).then((freshResponse) => {
                    if (freshResponse && freshResponse.status === 200) {
                        caches.open(CACHE_NAME).then((cache) => {
                            cache.put(event.request, freshResponse);
                        });
                    }
                }).catch(() => {}); // Fail silently
                
                return cachedResponse;
            }

            // Not in cache - fetch from network and cache
            return fetch(event.request).then((response) => {
                // Don't cache non-successful responses
                if (!response || response.status !== 200 || response.type !== 'basic') {
                    return response;
                }

                // Cache for future use
                const responseToCache = response.clone();
                caches.open(CACHE_NAME).then((cache) => {
                    cache.put(event.request, responseToCache);
                });

                return response;
            });
        })
    );
});
