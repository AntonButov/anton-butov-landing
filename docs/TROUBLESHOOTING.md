# 🔧 Troubleshooting Guide

## 🚨 Common Issues

### 1. **Permission Denied (403) Error**

#### **Quick Fix - Repository Settings:**
1. Go to: `https://github.com/AntonButov/anton-butov-landing/settings/actions`
2. **Workflow permissions**: "Read and write permissions"
3. ✅ **Allow GitHub Actions to create and approve pull requests**
4. Click **Save**

#### **Alternative Fix - Personal Access Token:**

If repository permissions don't work, create a PAT:

1. **Create Personal Access Token:**
   - Go to: `https://github.com/settings/tokens`
   - Click **Generate new token (classic)**
   - **Note**: `anton-butov-landing-deploy`
   - **Expiration**: 90 days
   - **Scopes**: ✅ `repo` (Full control of private repositories)
   - Click **Generate token**
   - **Copy the token** (you won't see it again!)

2. **Add Token to Repository Secrets:**
   - Go to: `https://github.com/AntonButov/anton-butov-landing/settings/secrets/actions`
   - Click **New repository secret**
   - **Name**: `PAT_TOKEN`
   - **Value**: Paste your token
   - Click **Add secret**

3. **Update CI/CD to use PAT:**
   ```yaml
   - name: Deploy to GitHub Pages
     uses: peaceiris/actions-gh-pages@v4.0.0
     with:
       github_token: ${{ secrets.PAT_TOKEN }}
   ```

### 2. **GitHub Pages Not Working**

#### **Check Settings:**
1. Settings → Pages
2. **Source**: Deploy from a branch
3. **Branch**: `gh-pages`
4. **Status**: Should show "Your site is published at..."

#### **Manual Test:**
```bash
# Test build locally
./gradlew wasmJsBrowserDistribution

# Check if files exist
ls -la composeApp/build/dist/wasmJs/productionExecutable/
```

### 3. **Build Fails**

#### **Common Build Issues:**
- **Java version**: Ensure JDK 21 is used
- **Gradle cache**: Clear cache if needed
- **Dependencies**: Check for version conflicts

#### **Debug Commands:**
```bash
# Clean and rebuild
./gradlew clean wasmJsBrowserDistribution

# Check available tasks
./gradlew tasks --group="build"

# Run with debug info
./gradlew wasmJsBrowserDistribution --info
```

## 🔍 Debug Steps

### **1. Check CI/CD Logs:**
- Go to Actions tab
- Click on failed workflow
- Check specific step logs

### **2. Verify Local Build:**
```bash
# Test the exact command from CI
./gradlew wasmJsBrowserDistribution
```

### **3. Check Repository Settings:**
- Actions permissions
- Pages configuration
- Branch protection rules

## 📞 Support

If issues persist:
1. Check GitHub Actions documentation
2. Verify all settings in this guide
3. Test with minimal changes
4. Consider using alternative deployment methods

## 🎯 Success Indicators

When everything works:
- ✅ CI/CD pipeline runs without errors
- ✅ `gh-pages` branch is created/updated
- ✅ Site available at `https://antonbutov.github.io/anton-butov-landing/`
- ✅ Version info displayed in footer
