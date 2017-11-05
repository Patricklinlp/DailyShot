package com.lp.dailyshot.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lp.dailyshot.fragment.FragmentHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 2017/10/22.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<FragmentHolder> mFragments = new ArrayList<>();

    public FragmentAdapter(FragmentManager manager, List<FragmentHolder> fragments) {
        super(manager);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTag();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
