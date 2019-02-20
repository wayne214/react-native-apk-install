
# react-native-apk-install

## Getting started

`$ npm install react-native-apk-install --save`

### Mostly automatic installation

`$ react-native link react-native-apk-install`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.wayne.apkinstaller.RNApkInstallPackage;` to the imports at the top of the file
  - Add `new RNCardviewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-apk-install'
  	project(':react-native-apk-install').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-apk-install/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-apk-install')
  	```


## Usage
```javascript
import RNFS from 'react-native-fs';
    import ApkInstaller from 'react-native-apk-installer'

     try {
         var filePath = RNFS.CachesDirectoryPath + '/com.example.app.apk';
         var download = RNFS.downloadFile({
           fromUrl: 'http://example.com/com.example.app.apk',
           toFile: filePath,
           progress: res => {
               console.log((res.bytesWritten / res.contentLength).toFixed(2));
           },
           progressDivider: 1
         });

         download.promise.then(result => {
           if(result.statusCode == 200) {
             console.log(filePath);
             ApkInstaller.install(filePath);
           }
         });
     }
     catch(error) {
         console.warn(error);
     }
```
  
