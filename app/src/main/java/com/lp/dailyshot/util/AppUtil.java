package com.lp.dailyshot.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Patrick on 2017/10/22.
 */

public class AppUtil {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };
    private static final String PHOTO_PATH = android.os.Environment.getExternalStorageDirectory() + "/dailyShot/Camera/";

    private static Context sAppContext;

    public static void setAppContext(Context context) {
        sAppContext = context;
    }

    public static Context getApplicationContext() {
        return sAppContext;
    }

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPhotoRootPath() {
        return PHOTO_PATH;
    }

    public static String getTodayPhotoPath() {
        return PHOTO_PATH + DateUtil.today() + ".jpg";
    }
}
