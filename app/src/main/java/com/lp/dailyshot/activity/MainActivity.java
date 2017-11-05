package com.lp.dailyshot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lp.dailyshot.R;
import com.lp.dailyshot.adapter.FragmentAdapter;
import com.lp.dailyshot.fragment.AboutFragment;
import com.lp.dailyshot.fragment.BaseFragment;
import com.lp.dailyshot.fragment.CameraFragment;
import com.lp.dailyshot.fragment.FragmentHolder;
import com.lp.dailyshot.fragment.GalleryFragment;
import com.lp.dailyshot.util.ResUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mViewPager;
    private List<FragmentHolder> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
        initViews();
    }

    private void initFragments() {
        BaseFragment a = new CameraFragment();
        BaseFragment b = new GalleryFragment();
        BaseFragment c = new AboutFragment();
        mFragments.add(new FragmentHolder(a, a.getTitle()));
        mFragments.add(new FragmentHolder(b, b.getTitle()));
        mFragments.add(new FragmentHolder(c, c.getTitle()));
    }

    private void initViews() {
        mTab = ResUtil.findViewById(R.id.base_tab, this);
        mViewPager = ResUtil.findViewById(R.id.base_pager, this);
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), mFragments));
        mTab.setupWithViewPager(mViewPager);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CameraFragment.REQUEST_CODE_CAMERA && resultCode == RESULT_OK) {
            Toast.makeText(this, "firstStep!", Toast.LENGTH_SHORT).show();
        }
    }

 }
