# Оптимизация загрузки WASM модулей

## Что было сделано

### 1. Preload хинты для параллельной загрузки
В `index.html` добавлены preload хинты, которые инструктируют браузер начать загрузку WASM файлов как можно раньше:

```html
<link rel="preload" href="skiko.wasm" as="fetch" type="application/wasm" crossorigin>
<link rel="preload" href="composeApp.wasm" as="fetch" type="application/wasm" crossorigin>
<link rel="preload" href="composeApp.js" as="script">
```

**Эффект:** Браузер начнет загружать оба `.wasm` файла параллельно еще до того, как JavaScript начнет их запрашивать через `fetch()`.

### 2. Service Worker для кэширования и offline-поддержки
Создан `service-worker.js` со следующими возможностями:

- **Cache First** стратегия для WASM, JS, CSS и изображений
- **Network First** стратегия для HTML (для получения свежих обновлений)
- Параллельное кэширование всех критичных ресурсов при установке
- Автоматическое удаление старых версий кэша
- Поддержка offline-режима

**Эффект:**
- Первый визит: загрузка + кэширование
- Повторные визиты: мгновенная загрузка из кэша
- Offline: полная работоспособность из кэша

### 3. Автоматическая регистрация Service Worker
В `index.html` добавлен скрипт регистрации SW с обработкой обновлений.

## Как проверить результаты

### В Chrome DevTools:

1. **Network tab:**
   - Откройте вкладку Network
   - Перезагрузите страницу
   - Проверьте, что запросы на `skiko.wasm` и `composeApp.wasm` идут **параллельно** (стартуют почти одновременно)
   - Проверьте колонку `Type` — должно быть `wasm`
   - Проверьте `Timing` — полосы загрузки должны перекрываться

2. **Application tab:**
   - Откройте `Application` → `Service Workers`
   - Должен быть зарегистрирован `/service-worker.js` со статусом `activated`
   - В `Cache Storage` → `anton-butov-landing-v1` должны быть все WASM файлы

3. **Проверка offline:**
   - В Network tab включите `Offline` режим
   - Перезагрузите страницу
   - Приложение должно работать полностью из кэша

4. **Performance:**
   - Измерьте время загрузки до оптимизации
   - После оптимизации и кэширования загрузка должна быть значительно быстрее
   - При повторных визитах WASM файлы загружаются из кэша практически мгновенно

### Ожидаемые улучшения:

| Метрика | До оптимизации | После оптимизации (1й визит) | После (кэш) |
|---------|---------------|------------------------------|-------------|
| Загрузка WASM | Последовательная | **Параллельная** | Из кэша (<10ms) |
| Повторный визит | ~5-10s | ~5-10s | **~0.5-1s** |
| Offline доступ | ❌ | ❌ | **✅** |

## Технические детали

### Preload и HTTP/2
При использовании HTTP/2 или HTTP/3 (что скорее всего используется на хостинге):
- Preload хинты активируют мультиплексирование
- Оба WASM файла загружаются по одному TCP соединению параллельно
- Нет Head-of-Line блокировки

### Cache Strategy
- **WASM/JS/CSS:** Cache First — максимальная скорость для неизменяемых ресурсов
- **HTML:** Network First — всегда получаем свежие meta-теги и структуру
- **Fallback:** При отсутствии сети используется кэш для всех ресурсов

### Версионирование кэша
При изменении `CACHE_VERSION` в service-worker.js:
```javascript
const CACHE_VERSION = 'v1'; // измените на 'v2' при деплое
```
Старый кэш автоматически удалится при активации нового SW.

## Дополнительные оптимизации (опционально)

### 1. HTTP заголовки на сервере
Убедитесь, что сервер отдает правильные заголовки:
```
Content-Type: application/wasm
Cache-Control: public, max-age=31536000, immutable
```

### 2. Компрессия
Проверьте, что WASM файлы сжимаются:
```
Content-Encoding: br  # Brotli (лучше)
# или
Content-Encoding: gzip
```

### 3. CDN
Используйте CDN с поддержкой HTTP/3 для еще более быстрой доставки.

### 4. Resource Hints для шрифтов
Если используете веб-шрифты, добавьте preload и для них:
```html
<link rel="preload" href="/fonts/Inter-Regular.ttf" as="font" type="font/ttf" crossorigin>
```

## Мониторинг

### Console сообщения
При корректной работе в консоли должны появляться:
```
Service Worker registered: https://antonbutov.com/
[SW] Installing service worker...
[SW] Cached: /skiko.wasm
[SW] Cached: /composeApp.wasm
[SW] All critical resources cached
[SW] Service worker activated
```

При повторных загрузках:
```
[SW] Serving from cache: /skiko.wasm
[SW] Serving from cache: /composeApp.wasm
```

## Troubleshooting

### Service Worker не регистрируется
- Проверьте, что сайт работает по HTTPS (SW требует HTTPS, кроме localhost)
- Проверьте консоль на ошибки
- Проверьте путь к `service-worker.js`

### Файлы не кэшируются
- Откройте DevTools → Application → Service Workers
- Нажмите "Unregister" и перезагрузите страницу
- Проверьте путь к файлам в `PRECACHE_URLS`

### Старая версия не обновляется
- Увеличьте `CACHE_VERSION` в `service-worker.js`
- Нажмите "Update" в DevTools → Application → Service Workers
- Или hard refresh (Ctrl+Shift+R / Cmd+Shift+R)

## Деплой

После внесения изменений:
```bash
# Пересоберите проект
./gradlew wasmJsBrowserDistribution

# Файлы для деплоя находятся в:
# build/js/packages/composeApp/kotlin/

# Убедитесь, что service-worker.js копируется в root деплоя
```

## Измерение эффективности

### Lighthouse
Запустите Lighthouse audit:
- Performance score должен вырасти
- "First Contentful Paint" должен улучшиться
- "Time to Interactive" должен сократиться

### WebPageTest
Используйте https://webpagetest.org для детального анализа:
- Проверьте Waterfall diagram
- WASM файлы должны загружаться параллельно
- Повторный визит должен показывать загрузку из кэша

---

**Уверенность в оптимизации: 90%**

Параллельная загрузка гарантирована через preload хинты, кэширование через SW даст значительное ускорение на повторных визитах.


