package com.lp.dailyshot.fragment;

import android.support.v4.app.Fragment;

import com.lp.dailyshot.R;
import com.lp.dailyshot.util.ResUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public class AboutFragment extends BaseFragment {
    protected String mTag = "AboutFragment";

    public AboutFragment() {
        super();
        mTag = "AboutFragment";
    }

    @Override
    public String getTitle() {
        return ResUtil.getString(R.string.tab_name_config);
    }
}
