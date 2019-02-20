
# react-native-cardview

## Getting started

`$ npm install react-native-cardview --save`

### Mostly automatic installation

`$ react-native link react-native-cardview`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.wayne.apkinstaller.RNCardviewPackage;` to the imports at the top of the file
  - Add `new RNCardviewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-cardview'
  	project(':react-native-cardview').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-cardview/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-cardview')
  	```


## Usage
```javascript
import RNCardview from 'react-native-cardview';

// TODO: What to do with the module?
RNCardview;
```
  