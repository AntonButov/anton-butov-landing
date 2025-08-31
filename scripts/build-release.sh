#!/usr/bin/env bash
set -euo pipefail

# Build optimized production bundle
./gradlew :composeApp:wasmJsBrowserDistribution --console=plain

# Gzip static assets for faster delivery
DIST_DIR="composeApp/build/dist/wasmJs/productionExecutable"
if [ -d "$DIST_DIR" ]; then
  find "$DIST_DIR" -type f -name "*" -exec gzip -kf {} \;
fi

echo "Distribution is available in $DIST_DIR"

