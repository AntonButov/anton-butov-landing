#!/bin/bash

# Image optimization script for faster loading
# This script optimizes PNG and SVG images for web delivery

RESOURCES_DIR="composeApp/src/wasmJsMain/resources"
BACKUP_DIR="composeApp/src/wasmJsMain/resources/backup"

echo "🖼️ Starting image optimization..."

# Check if ImageMagick is available
if ! command -v convert &> /dev/null; then
    echo "❌ ImageMagick (convert command) not found."
    echo "Please install it:"
    echo "  Ubuntu/Debian: sudo apt-get install imagemagick"
    echo "  macOS: brew install imagemagick"
    echo "  Windows: Download from https://imagemagick.org/"
    exit 1
fi

# Create backup directory
mkdir -p "$BACKUP_DIR"

# Function to optimize PNG images
optimize_png() {
    local input_file="$1"
    local filename=$(basename "$input_file")
    local backup_file="$BACKUP_DIR/$filename"
    
    echo "📸 Optimizing $filename..."
    
    # Create backup
    cp "$input_file" "$backup_file"
    
    # Get original size
    local original_size=$(stat -c%s "$input_file")
    
    # Optimize PNG with multiple techniques
    convert "$input_file" \
        -strip \
        -quality 85 \
        -define png:compression-level=9 \
        -define png:compression-strategy=1 \
        -define png:exclude-chunk=all \
        -colors 256 \
        "$input_file.optimized"
    
    # Check if optimization was successful and beneficial
    if [ -f "$input_file.optimized" ]; then
        local optimized_size=$(stat -c%s "$input_file.optimized")
        local savings=$((original_size - optimized_size))
        local savings_percent=$((savings * 100 / original_size))
        
        if [ "$optimized_size" -lt "$original_size" ] && [ "$savings_percent" -gt 5 ]; then
            mv "$input_file.optimized" "$input_file"
            echo "✅ $filename optimized: $((original_size/1024))KB → $((optimized_size/1024))KB (${savings_percent}% saved)"
        else
            rm "$input_file.optimized"
            echo "ℹ️  $filename: optimization not beneficial, keeping original"
        fi
    fi
}

# Function to optimize SVG images
optimize_svg() {
    local input_file="$1"
    local filename=$(basename "$input_file")
    local backup_file="$BACKUP_DIR/$filename"
    
    echo "🎨 Optimizing $filename..."
    
    # Create backup
    cp "$input_file" "$backup_file"
    
    # Get original size
    local original_size=$(stat -c%s "$input_file")
    
    # Optimize SVG by removing unnecessary elements and minifying
    sed -i 's/<!--.*-->//g' "$input_file"  # Remove comments
    sed -i 's/[[:space:]]\+/ /g' "$input_file"  # Normalize whitespace
    sed -i 's/> </></g' "$input_file"  # Remove spaces between tags
    
    local optimized_size=$(stat -c%s "$input_file")
    local savings=$((original_size - optimized_size))
    local savings_percent=$((savings * 100 / original_size))
    
    if [ "$savings_percent" -gt 1 ]; then
        echo "✅ $filename optimized: $((original_size))B → $((optimized_size))B (${savings_percent}% saved)"
    else
        echo "ℹ️  $filename: minimal optimization benefit"
    fi
}

# Optimize all PNG files
echo "🔍 Finding PNG images..."
find "$RESOURCES_DIR" -name "*.png" -type f | while read -r file; do
    optimize_png "$file"
done

# Optimize all SVG files
echo "🔍 Finding SVG images..."
find "$RESOURCES_DIR" -name "*.svg" -type f | while read -r file; do
    optimize_svg "$file"
done

# Summary
echo ""
echo "📊 Optimization Summary:"
echo "Backup files created in: $BACKUP_DIR"
echo "To restore originals: cp $BACKUP_DIR/* $RESOURCES_DIR/"

# Check if we have any large files that could benefit from WebP conversion
echo ""
echo "💡 Additional optimization suggestions:"
find "$RESOURCES_DIR" -name "*.png" -size +100k -type f | while read -r file; do
    echo "Consider converting $(basename "$file") to WebP for better compression"
done

echo "✅ Image optimization complete!"
