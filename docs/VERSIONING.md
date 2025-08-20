# 📋 Versioning Guide

## 🎯 Overview

This project uses semantic versioning (SemVer) with the format `MAJOR.MINOR.PATCH`.

## 📊 Version Components

- **MAJOR**: Breaking changes, major features
- **MINOR**: New features, backward compatible
- **PATCH**: Bug fixes, backward compatible
- **BUILD**: Internal build number (auto-incremented)

## 🚀 Current Version

- **Version**: `1.0.0`
- **Build**: `1`
- **Build Date**: `2024-12-19`

## 🛠️ How to Update Version

### Using the Script (Recommended)

```bash
# Increment patch version (1.0.0 -> 1.0.1)
./scripts/update-version.sh patch

# Increment minor version (1.0.0 -> 1.1.0)
./scripts/update-version.sh minor

# Increment major version (1.0.0 -> 2.0.0)
./scripts/update-version.sh major

# Set specific version and build number
./scripts/update-version.sh patch 5
```

### Manual Update

1. **Update `gradle/libs.versions.toml`:**
   ```toml
   [versions]
   app-version = "1.0.1"
   app-version-code = "2"
   ```

2. **Update `AppVersion.kt`:**
   ```kotlin
   object AppVersion {
       const val VERSION = "1.0.1"
       const val VERSION_CODE = 2
       const val BUILD_DATE = "2024-12-19"
   }
   ```

## 📍 Where Version is Displayed

- **Footer**: Shows version in bottom of the page
- **Build Info**: Available in `AppVersion.getVersionInfo()`
- **CI/CD**: Version is used in deployment tags

## 🔄 Version Update Workflow

1. **Development**: Work on features/fixes
2. **Update Version**: Run `./scripts/update-version.sh patch`
3. **Commit**: `git add . && git commit -m "bump version to 1.0.1"`
4. **Tag**: `git tag v1.0.1`
5. **Push**: `git push && git push --tags`
6. **Deploy**: CI/CD automatically deploys new version

## 📋 Version History

| Version | Build | Date | Changes |
|---------|-------|------|---------|
| 1.0.0 | 1 | 2024-12-19 | Initial release |

## 🎯 Best Practices

- **Patch**: Bug fixes, typos, minor improvements
- **Minor**: New features, UI improvements
- **Major**: Breaking changes, redesigns
- **Always**: Update build number for each release
- **Test**: Verify version display after update
