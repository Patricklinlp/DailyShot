package com.lp.dailyshot.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Patrick on 2017/10/22.
 */

public class FragmentHolder {
    private Fragment mFragment;
    private String mTag;

    public FragmentHolder(Fragment fragment, String tag) {
        mFragment = fragment;
        mTag = tag;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public String getTag() {
        return mTag;
    }
}
