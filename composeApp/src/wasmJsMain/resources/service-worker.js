// Service Worker для кэширования WASM файлов и оптимизации загрузки
const CACHE_VERSION = 'v2';
const CACHE_NAME = `anton-butov-landing-${CACHE_VERSION}`;

// Критичные ресурсы для кэширования
const PRECACHE_URLS = [
  '/',
  '/index.html',
  '/styles.css',
  '/composeApp.js',
  '/composeApp.wasm',
  '/skiko.wasm',
  '/skiko.js',
  '/skiko.mjs',
  '/composeApp.mjs',
  '/composeApp.uninstantiated.mjs',
  '/custom-formatters.js',
  '/preview.png'
];

// Установка Service Worker и предварительное кэширование
self.addEventListener('install', (event) => {
  console.log('[SW] Installing service worker...');
  
  event.waitUntil(
    (async () => {
      try {
        const cache = await caches.open(CACHE_NAME);
        
        // Параллельная загрузка всех ресурсов с улучшенной обработкой ошибок
        const cacheResults = await Promise.allSettled(
          PRECACHE_URLS.map(async (url) => {
            try {
              await cache.add(url);
              console.log(`[SW] Cached: ${url}`);
              return { url, status: 'success' };
            } catch (error) {
              console.warn(`[SW] Failed to cache ${url}:`, error.message);
              return { url, status: 'failed', error: error.message };
            }
          })
        );
        
        // Статистика кэширования
        const successful = cacheResults.filter(r => r.status === 'fulfilled' && r.value.status === 'success').length;
        const failed = cacheResults.length - successful;
        console.log(`[SW] Cache stats: ${successful} successful, ${failed} failed`);
        
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
          
          // Если нет в кэше - загружаем из сети и кэширую
          console.log(`[SW] Fetching from network: ${url.pathname}`);
          const networkResponse = await fetch(request);
          
          // Кэшируем только успешные ответы
          if (networkResponse && networkResponse.status === 200) {
            cache.put(request, networkResponse.clone());
          }
          
          return networkResponse;
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

