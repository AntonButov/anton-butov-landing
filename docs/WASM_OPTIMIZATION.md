# WASM Bundle Size Optimization

This guide focuses on reducing the size of your Kotlin/WASM bundles to improve loading times.

## Current Bundle Analysis

Typical Compose Multiplatform WASM app:

```
composeApp.wasm:  ~5-10 MB  (your application code)
skiko.wasm:       ~8-15 MB  (Skiko graphics engine)
Total:            ~15-25 MB (uncompressed)
```

With compression (Brotli/Gzip):
```
composeApp.wasm.br: ~1-2 MB   (80-90% reduction)
skiko.wasm.br:      ~2-3 MB   (70-85% reduction)
Total:              ~3-5 MB   (compressed)
```

## Gradle Build Optimizations

### 1. Enable Production Mode

In your `build.gradle.kts`:

```kotlin
kotlin {
    wasmJs {
        binaries.executable()
        browser {
            commonWebpackConfig {
                // Enable production optimizations
                mode = org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode.PRODUCTION
                
                // Dead code elimination
                devtool = false
                
                // Minimize output
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}
```

### 2. Gradle Properties

Add to `gradle.properties`:

```properties
# Kotlin optimizations
kotlin.js.compiler=ir
kotlin.mpp.stability.nowarn=true

# Gradle performance
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.configureondemand=true
org.gradle.jvmargs=-Xmx4g -XX:+HeapDumpOnOutOfMemoryError

# Dead code elimination
kotlin.native.cacheKind=static
kotlin.native.ignoreDisabledTargets=true
```

### 3. ProGuard-like Optimizations

While ProGuard doesn't work directly with WASM, you can:

1. **Remove unused dependencies**:
   - Audit your `dependencies` block
   - Remove libraries you don't actually use
   - Use lightweight alternatives when possible

2. **Use `api` vs `implementation`**:
   ```kotlin
   dependencies {
       implementation(compose.runtime)  // Not exposed
       api(compose.foundation)          // Exposed to consumers
   }
   ```

3. **Avoid reflection** where possible (increases bundle size)

## Code-Level Optimizations

### 1. Lazy Loading Components

Instead of loading everything upfront:

```kotlin
// ❌ Bad: All loaded immediately
@Composable
fun App() {
    MainScreen()
    ProfileScreen()
    SettingsScreen()
}

// ✅ Good: Load on demand
@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("main") }
    
    when (currentScreen) {
        "main" -> MainScreen()
        "profile" -> ProfileScreen()
        "settings" -> SettingsScreen()
    }
}
```

### 2. Resource Optimization

**Images:**
- Use WebP format (smaller than PNG/JPEG)
- Compress images before bundling
- Load large images asynchronously

**Fonts:**
- Use system fonts when possible
- Subset custom fonts (include only needed characters)
- Use `font-display: swap` for faster rendering

### 3. Avoid Heavy Dependencies

Common heavy dependencies to watch:

```kotlin
// ❌ Heavy: Full Ktor client
implementation("io.ktor:ktor-client-core:3.2.1")
implementation("io.ktor:ktor-client-json:3.2.1")
implementation("io.ktor:ktor-client-serialization:3.2.1")

// ✅ Lighter: Use browser fetch API
// Or use minimal Ktor configuration
implementation("io.ktor:ktor-client-core:3.2.1")
```

## Server-Side Optimizations

### 1. Compression (Critical!)

Always serve WASM with compression:

```apache
# Apache
<IfModule mod_brotli.c>
    AddOutputFilterByType BROTLI_COMPRESS application/wasm
</IfModule>

<IfModule mod_deflate.c>
    AddOutputFilterByType DEFLATE application/wasm
</IfModule>
```

```nginx
# Nginx
gzip on;
gzip_types application/wasm;
gzip_min_length 1000;

brotli on;
brotli_types application/wasm;
```

### 2. Pre-compress Files

During build, create pre-compressed versions:

```bash
# Brotli (best compression)
find build/dist -name "*.wasm" -exec brotli -9 {} \;

# Gzip (fallback)
find build/dist -name "*.wasm" -exec gzip -9 -k {} \;
```

Your CI/CD already does this! (See `.github/workflows/ci.yml:106-113`)

### 3. Range Requests

Enable HTTP range requests for resumable downloads:

```apache
# Apache
Header set Accept-Ranges bytes
```

```nginx
# Nginx (enabled by default)
```

## Alternative Approaches

### Consider Kotlin/JS for Some Use Cases

If you don't need:
- Skiko graphics
- Code sharing with native (Android/iOS)
- Maximum runtime performance

Then Kotlin/JS might be better:

| Feature | Kotlin/WASM | Kotlin/JS |
|---------|-------------|-----------|
| Bundle Size | 15-25 MB | 1-3 MB |
| Cold Start | 7-15s | 1-3s |
| Runtime Speed | ⚡️⚡️⚡️ Fast | ⚡️⚡️ Medium |
| Graphics | ✅ Skiko | ❌ Canvas only |
| Code Sharing | ✅ Full | ⚠️ Limited |
| SSR Support | ❌ Limited | ✅ Full (Kilua) |

### Hybrid Approach

1. **Initial Load**: Lightweight JS/HTML shell
2. **Lazy Load**: WASM modules on demand
3. **Progressive Enhancement**: Core features work without WASM

Example structure:
```
index.html (instant)
  ↓
app.js (100 KB, fast)
  ↓
composeApp.wasm (lazy load when needed)
```

## Monitoring Bundle Size

### Track Size Over Time

Add to CI/CD:

```yaml
- name: Bundle Size Report
  run: |
    echo "## Bundle Sizes" >> $GITHUB_STEP_SUMMARY
    find build/dist -name "*.wasm" -exec ls -lh {} \; >> $GITHUB_STEP_SUMMARY
```

### Set Size Budgets

Fail build if bundle exceeds limit:

```bash
MAX_SIZE=30000000  # 30 MB
ACTUAL=$(find build/dist -name "*.wasm" -exec stat -f%z {} \; | awk '{s+=$1} END {print s}')

if [ $ACTUAL -gt $MAX_SIZE ]; then
  echo "Bundle too large: $ACTUAL bytes (max: $MAX_SIZE)"
  exit 1
fi
```

## Benchmarking Tools

Compare your load times:

```bash
# Lighthouse
npx lighthouse https://yoursite.com --only-categories=performance

# WebPageTest
# Use https://www.webpagetest.org/

# Bundle Analysis
npx webpack-bundle-analyzer build/dist/stats.json
```

## Real-World Comparison

**Your Portfolio (Kotlin/WASM + Compose)**:
- Bundle: ~20 MB → ~4 MB compressed
- Cold start: ~10s
- Warm start: ~1s (with service worker)
- Runtime: ⚡️⚡️⚡️

**Spotify Clone (Kotlin/JS + Kilua + SSR)**:
- Bundle: ~2 MB → ~500 KB compressed  
- Cold start: ~1.5s
- Warm start: ~0.5s
- Runtime: ⚡️⚡️

**Trade-offs**: They chose faster loading, you chose richer features and code sharing.

## Summary

### Quick Wins
1. ✅ Enable Brotli compression (70-85% reduction)
2. ✅ Use production webpack mode
3. ✅ Implement service worker caching
4. ✅ Preload WASM modules
5. ✅ Show real loading progress

### Long-term Optimizations
1. Remove unused dependencies
2. Lazy load heavy components
3. Use CDN for static assets
4. Consider code splitting
5. Monitor bundle size in CI/CD

### When to Switch to Kotlin/JS
- If cold start time is critical (< 3s requirement)
- If you don't need Skiko graphics
- If SSR is essential
- If bundle size is a hard constraint

---

**Last Updated**: October 2025  
**Version**: 1.0

