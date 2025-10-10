#!/bin/bash

# Generate favicons from brasessOff.svg
# Requires: ImageMagick (convert command)

SVG_FILE="composeApp/src/commonMain/composeResources/drawable/brasessOff.svg"
OUTPUT_DIR="composeApp/src/wasmJsMain/resources"

echo "Generating favicons from $SVG_FILE..."

# Create output directory if it doesn't exist
mkdir -p "$OUTPUT_DIR"

# Generate favicon-16x16.png
convert "$SVG_FILE" -resize 16x16 "$OUTPUT_DIR/favicon-16x16.png"
echo "Generated favicon-16x16.png"

# Generate favicon-32x32.png  
convert "$SVG_FILE" -resize 32x32 "$OUTPUT_DIR/favicon-32x32.png"
echo "Generated favicon-32x32.png"

# Generate apple-touch-icon.png (180x180)
convert "$SVG_FILE" -resize 180x180 "$OUTPUT_DIR/apple-touch-icon.png"
echo "Generated apple-touch-icon.png"

# Generate android-chrome-192x192.png
convert "$SVG_FILE" -resize 192x192 "$OUTPUT_DIR/android-chrome-192x192.png"
echo "Generated android-chrome-192x192.png"

# Generate android-chrome-512x512.png
convert "$SVG_FILE" -resize 512x512 "$OUTPUT_DIR/android-chrome-512x512.png"
echo "Generated android-chrome-512x512.png"

echo "All favicons generated successfully!"
echo "Files created in $OUTPUT_DIR:"
ls -la "$OUTPUT_DIR"/*icon* "$OUTPUT_DIR"/favicon*
