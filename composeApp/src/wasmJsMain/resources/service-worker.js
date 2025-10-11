// Service Worker для кэширования WASM файлов и оптимизации загрузки
const CACHE_VERSION = 'v5';
const CACHE_NAME = `anton-butov-landing-${CACHE_VERSION}`;

// Критичные ресурсы для кэширования (только файлы, которые точно существуют)
const PRECACHE_URLS = [
  '/',
  '/index.html',
  '/styles.css',
  '/preview.png',
  '/favicon.svg',
  '/favicon-32x32.png',
  '/favicon-16x16.png',
  '/apple-touch-icon.png',
  '/site.webmanifest'
];

// WASM и JS файлы кэшируются динамически при первом запросе
const DYNAMIC_CACHE_PATTERNS = [
  /\.wasm$/,
  /\.js$/,
  /\.mjs$/,
  /composeApp\./,
  /skiko\./
];

// Установка Service Worker и предварительное кэширование
self.addEventListener('install', (event) => {
  console.log('[SW] Installing service worker...');
  
  event.waitUntil(
    (async () => {
      try {
        const cache = await caches.open(CACHE_NAME);
        
        // Кэшируем только критичные статические ресурсы
        try {
          await cache.addAll(PRECACHE_URLS);
          console.log(`[SW] Cached ${PRECACHE_URLS.length} critical resources`);
        } catch (error) {
          console.warn('[SW] Some critical resources failed to cache:', error);
        }
        
        console.log('[SW] All critical resources cached');
        
        // Принудительная активация нового SW
        self.skipWaiting();
      } catch (error) {
        console.error('[SW] Installation failed:', error);
      }
    })()
  );
});

// Активация и удаление старых кэшей
self.addEventListener('activate', (event) => {
  console.log('[SW] Activating service worker...');
  
  event.waitUntil(
    (async () => {
      // Удаляем старые кэши
      const cacheNames = await caches.keys();
      await Promise.all(
        cacheNames
          .filter((name) => name !== CACHE_NAME)
          .map((name) => {
            console.log(`[SW] Deleting old cache: ${name}`);
            return caches.delete(name);
          })
      );
      
      // Захватываем все открытые вкладки
      await self.clients.claim();
      console.log('[SW] Service worker activated');
    })()
  );
});

// Стратегия загрузки: Cache First для WASM, Network First для HTML
self.addEventListener('fetch', (event) => {
  const { request } = event;
  const url = new URL(request.url);
  
  // Игнорируем chrome-extension и другие протоколы
  if (!url.protocol.startsWith('http')) {
    return;
  }
  
  // Определяем стратегию кэширования
  const isWasm = url.pathname.endsWith('.wasm');
  const isJs = url.pathname.endsWith('.js') || url.pathname.endsWith('.mjs');
  const isStatic = isWasm || isJs || url.pathname.endsWith('.css') || url.pathname.endsWith('.png');
  const isDynamicCacheable = DYNAMIC_CACHE_PATTERNS.some(pattern => pattern.test(url.pathname));
  
  if (isStatic) {
    // Cache First для статических ресурсов (WASM, JS, CSS, изображения)
    event.respondWith(
      (async () => {
        try {
          const cache = await caches.open(CACHE_NAME);
          const cachedResponse = await cache.match(request);
          
          if (cachedResponse) {
            console.log(`[SW] Serving from cache: ${url.pathname}`);
            return cachedResponse;
          }
          
          // Если нет в кэше - загружаем из сети и кэшируем
          console.log(`[SW] Fetching from network: ${url.pathname}`);
          try {
            const networkResponse = await fetch(request);
            
            // Кэшируем только успешные ответы
            if (networkResponse && networkResponse.status === 200) {
              cache.put(request, networkResponse.clone());
              console.log(`[SW] Cached from network: ${url.pathname}`);
            } else {
              console.warn(`[SW] Failed to fetch ${url.pathname}: ${networkResponse.status}`);
            }
            
            return networkResponse;
          } catch (error) {
            console.error(`[SW] Network error for ${url.pathname}:`, error);
            throw error;
          }
        } catch (error) {
          console.error(`[SW] Fetch failed for ${url.pathname}:`, error);
          throw error;
        }
      })()
    );
  } else {
    // Network First для HTML и других динамических ресурсов
    event.respondWith(
      (async () => {
        try {
          const networkResponse = await fetch(request);
          
          // Обновляем кэш при успешной загрузке
          if (networkResponse && networkResponse.status === 200) {
            const cache = await caches.open(CACHE_NAME);
            cache.put(request, networkResponse.clone());
          }
          
          return networkResponse;
        } catch (error) {
          // Fallback на кэш при ошибке сети
          const cachedResponse = await caches.match(request);
          if (cachedResponse) {
            console.log(`[SW] Network failed, serving from cache: ${url.pathname}`);
            return cachedResponse;
          }
          
          // Если файл не найден и это не критичный ресурс, возвращаем заглушку
          if (url.pathname.includes('.js') || url.pathname.includes('.mjs')) {
            console.warn(`[SW] Resource not found: ${url.pathname}`);
            return new Response('', { 
              status: 404, 
              statusText: 'Not Found',
              headers: { 'Content-Type': 'text/plain' }
            });
          }
          
          throw error;
        }
      })()
    );
  }
});

// Сообщения от главного потока
self.addEventListener('message', (event) => {
  if (event.data && event.data.type === 'SKIP_WAITING') {
    self.skipWaiting();
  }
  
  if (event.data && event.data.type === 'CLEAR_CACHE') {
    event.waitUntil(
      caches.delete(CACHE_NAME).then(() => {
        console.log('[SW] Cache cleared');
      })
    );
  }
});

