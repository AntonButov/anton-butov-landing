#!/bin/bash

# Script to update version in the project
# Usage: ./scripts/update-version.sh [major|minor|patch] [version_code]

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Function to print colored output
print_info() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Check if version type is provided
if [ $# -eq 0 ]; then
    print_error "Usage: $0 [major|minor|patch] [version_code]"
    print_info "Examples:"
    print_info "  $0 patch        # Increment patch version (1.0.0 -> 1.0.1)"
    print_info "  $0 minor        # Increment minor version (1.0.0 -> 1.1.0)"
    print_info "  $0 major        # Increment major version (1.0.0 -> 2.0.0)"
    print_info "  $0 patch 5      # Set specific version and version code"
    exit 1
fi

VERSION_TYPE=$1
VERSION_CODE=$2

# Get current version from libs.versions.toml
CURRENT_VERSION=$(grep 'app-version = ' gradle/libs.versions.toml | cut -d'"' -f2)
CURRENT_VERSION_CODE=$(grep 'app-version-code = ' gradle/libs.versions.toml | cut -d'"' -f2)

# Validate current version
if [ -z "$CURRENT_VERSION" ] || [ -z "$CURRENT_VERSION_CODE" ]; then
    print_error "Could not read current version from gradle/libs.versions.toml"
    exit 1
fi

print_info "Current version: $CURRENT_VERSION (build $CURRENT_VERSION_CODE)"

# Parse current version
IFS='.' read -ra VERSION_PARTS <<< "$CURRENT_VERSION"
MAJOR=${VERSION_PARTS[0]}
MINOR=${VERSION_PARTS[1]}
PATCH=${VERSION_PARTS[2]}

# Calculate new version
case $VERSION_TYPE in
    major)
        NEW_MAJOR=$((MAJOR + 1))
        NEW_MINOR=0
        NEW_PATCH=0
        ;;
    minor)
        NEW_MAJOR=$MAJOR
        NEW_MINOR=$((MINOR + 1))
        NEW_PATCH=0
        ;;
    patch)
        NEW_MAJOR=$MAJOR
        NEW_MINOR=$MINOR
        NEW_PATCH=$((PATCH + 1))
        ;;
    *)
        print_error "Invalid version type: $VERSION_TYPE"
        print_info "Valid types: major, minor, patch"
        exit 1
        ;;
esac

NEW_VERSION="$NEW_MAJOR.$NEW_MINOR.$NEW_PATCH"

# Use provided version code or increment current
if [ -n "$VERSION_CODE" ]; then
    NEW_VERSION_CODE=$VERSION_CODE
else
    NEW_VERSION_CODE=$((CURRENT_VERSION_CODE + 1))
fi

print_info "New version: $NEW_VERSION (build $NEW_VERSION_CODE)"

# Update libs.versions.toml
sed -i "s/app-version = \"$CURRENT_VERSION\"/app-version = \"$NEW_VERSION\"/" gradle/libs.versions.toml
sed -i "s/app-version-code = \"$CURRENT_VERSION_CODE\"/app-version-code = \"$NEW_VERSION_CODE\"/" gradle/libs.versions.toml

# Update AppVersion.kt
sed -i "s/const val VERSION = \"$CURRENT_VERSION\"/const val VERSION = \"$NEW_VERSION\"/" composeApp/src/commonMain/kotlin/dev/butov/anton/AppVersion.kt
sed -i "s/const val VERSION_CODE = $CURRENT_VERSION_CODE/const val VERSION_CODE = $NEW_VERSION_CODE/" composeApp/src/commonMain/kotlin/dev/butov/anton/AppVersion.kt

# Update build date
BUILD_DATE=$(date +%Y-%m-%d)
sed -i "s/const val BUILD_DATE = \"[0-9]\{4\}-[0-9]\{2\}-[0-9]\{2\}\"/const val BUILD_DATE = \"$BUILD_DATE\"/" composeApp/src/commonMain/kotlin/dev/butov/anton/AppVersion.kt

print_info "Version updated successfully!"
print_info "Files updated:"
print_info "  - gradle/libs.versions.toml"
print_info "  - composeApp/src/commonMain/kotlin/dev/butov/anton/AppVersion.kt"

# Show git status
print_info "Git status:"
git status --porcelain | grep -E "(gradle/libs.versions.toml|AppVersion.kt)" || true
