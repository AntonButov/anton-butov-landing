This is a Kotlin Multiplatform project targeting Web.

run
```agsl
./gradlew wasmJsBrowserDevelopmentRun

```

## Release build

To generate a production bundle with minification and gzip files run:

```bash
./scripts/build-release.sh
```

The optimized files will be placed in `composeApp/build/dist/wasmJs/productionExecutable`.
Serve these assets with HTTP compression or a CDN to improve the first load time.
