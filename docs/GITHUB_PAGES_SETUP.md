# 🌐 GitHub Pages Setup Guide

## 🔧 Required Settings

### 1. **Enable GitHub Pages**
1. Go to repository: `https://github.com/AntonButov/anton-butov-landing`
2. Settings → Pages
3. **Source**: Deploy from a branch
4. **Branch**: `gh-pages` (will be created automatically)
5. **Folder**: `/ (root)`
6. Click **Save**

### 2. **Configure Repository Permissions**
1. Settings → Actions → General
2. **Workflow permissions**: "Read and write permissions"
3. ✅ **Allow GitHub Actions to create and approve pull requests**
4. Click **Save**

### 3. **Create Environment (Optional but Recommended)**
1. Settings → Environments
2. Click **New environment**
3. **Environment name**: `github-pages`
4. **Protection rules**: None (or add as needed)
5. Click **Configure environment**

## 🚀 How It Works

### CI/CD Pipeline Flow:
1. **Push to master** → Triggers deployment
2. **Build** → `./gradlew wasmJsBrowserDistribution`
3. **Deploy** → Creates/updates `gh-pages` branch
4. **Publish** → Available at `https://antonbutov.github.io/anton-butov-landing/`

### Files Deployed:
- `index.html` - Main page
- `composeApp.js` - Application bundle
- `*.wasm` - WebAssembly modules
- Other assets (CSS, images, etc.)

## 🔍 Troubleshooting

### Common Issues:

#### 1. **Permission Denied (403)**
- ✅ Ensure "Read and write permissions" is enabled
- ✅ Check that GitHub Pages is enabled
- ✅ Verify `gh-pages` branch exists

#### 2. **Branch Not Found**
- The `gh-pages` branch is created automatically by the action
- First deployment may take a few minutes

#### 3. **Build Fails**
- Check CI/CD logs in Actions tab
- Verify `./gradlew wasmJsBrowserDistribution` works locally

### Manual Deployment Test:
```bash
# Test build locally
./gradlew wasmJsBrowserDistribution

# Check output directory
ls -la composeApp/build/dist/wasmJs/productionExecutable/
```

## 📋 Verification Steps

1. **Check Actions**: Go to Actions tab, verify deployment succeeded
2. **Check Pages**: Go to Settings → Pages, verify deployment status
3. **Check URL**: Visit `https://antonbutov.github.io/anton-butov-landing/`
4. **Check Branch**: Verify `gh-pages` branch exists with files

## 🎯 Expected Result

After successful setup:
- ✅ CI/CD pipeline runs on push to master
- ✅ Build succeeds with `./gradlew wasmJsBrowserDistribution`
- ✅ Deployment creates/updates `gh-pages` branch
- ✅ Site available at `https://antonbutov.github.io/anton-butov-landing/`
- ✅ Version info displayed in footer
