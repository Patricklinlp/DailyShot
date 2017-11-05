package com.lp.dailyshot.util;

import java.io.File;

/**
 * Created by Patrick on 2017/11/5.
 */

public class FileUtil {

    private static final String TAG = "FileUtil";

    public static void checkAndMakeDirs(String filePath) {
        File file = new File(filePath);
        LogUtil.d(TAG, "file exists:" + file.exists());
        if (file.exists()) {
            return;
        }
        LogUtil.d(TAG, "file.isDirectory:" + file.isDirectory());
        if (file.isDirectory()) {
            LogUtil.d(TAG, "file mkdirs:" + filePath);
            file.mkdirs();
        }
        file.mkdirs();
    }

    public static boolean exists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static boolean delete(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}
