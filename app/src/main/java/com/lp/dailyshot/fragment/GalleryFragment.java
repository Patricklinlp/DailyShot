package com.lp.dailyshot.fragment;

import android.support.v4.app.Fragment;

import com.lp.dailyshot.R;
import com.lp.dailyshot.util.ResUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public class GalleryFragment extends BaseFragment {
    protected String mTag = "GalleryFragment";

    public GalleryFragment() {
        super();
        mTag = "GalleryFragment";
    }

    @Override
    public String getTitle() {
        return ResUtil.getString(R.string.tab_name_yesterday);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
