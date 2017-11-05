package com.lp.dailyshot.fragment;

import com.lp.dailyshot.R;
import com.lp.dailyshot.util.ResUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public class AboutFragment extends BaseFragment {

    public AboutFragment() {
        super();
    }

    @Override
    public String getTitle() {
        return ResUtil.getString(R.string.tab_name_config);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
