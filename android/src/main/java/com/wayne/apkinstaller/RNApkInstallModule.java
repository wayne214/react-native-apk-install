
package com.wayne.apkinstaller;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RNApkInstallModule extends ReactContextBaseJavaModule {

  private ReactApplicationContext _context = null;

  public RNApkInstallModule(ReactApplicationContext reactContext) {
    super(reactContext);
    _context = reactContext;
  }

  @Override
  public String getName() {
    return "RNApkInstall";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    return constants;
  }

  @ReactMethod
  // public void show(String message, int duration) {
  public void test(String message) {
    Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
  }

  @ReactMethod
  public void install(String path) {
    String cmd = "chmod 777 " +path;
    try {
      Runtime.getRuntime().exec(cmd);
    } catch (Exception e) {
      e.printStackTrace();
    }
    File file= new File(path);
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
    if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.N) { //判读版本是否在7.0以上
      //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
      Uri apkUri =
              FileProvider.getUriForFile(_context, "com.huaxing.alpha.apps.apollo.FileProvider", file);
      //添加这一句表示对目标应用临时授权该Uri所代表的文件
      intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
    }else{
      intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
    }

    _context.startActivity(intent);
  }
}