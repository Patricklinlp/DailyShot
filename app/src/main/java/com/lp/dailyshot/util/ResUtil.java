package com.lp.dailyshot.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by Patrick on 2017/10/22.
 */

public class ResUtil {

    public static <T extends View> T findViewById(int resId, View parentView) {
        return parentView == null? null : (T)parentView.findViewById(resId);
    }

    public static <T extends View> T findViewById(int resId, Activity activity) {
        return activity == null? null : (T)activity.findViewById(resId);
    }

    public static String getString(int resStringId) {
        return AppUtil.getApplicationContext().getString(resStringId);
    }
}
