package com.lp.dailyshot.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.dailyshot.util.LogUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public abstract class BaseFragment extends Fragment {

    protected String mTag = "BaseFragment";

    public abstract String getTitle();

    public BaseFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.d(mTag, "onCreateView(inflater:" + inflater + ", container:" + container + ", savedInstanceState:" + savedInstanceState + ")");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        LogUtil.d(mTag, "onCreate(savedInstanceState:" + savedInstanceState + ")");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LogUtil.d(mTag, "onViewCreated(view:" + view + ", savedInstanceState:" + savedInstanceState + ")");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        LogUtil.d(mTag, "onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        LogUtil.d(mTag, "onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtil.d(mTag, "onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        LogUtil.d(mTag, "onStop()");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        LogUtil.d(mTag, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        LogUtil.d(mTag, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onLowMemory() {
        LogUtil.d(mTag, "onLowMemory()");
        super.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        LogUtil.d(mTag, "onSaveInstanceState(outState:" + outState + ")");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        LogUtil.d(mTag, "onActivityCreated(savedInstanceState:" + savedInstanceState + ")");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        LogUtil.d(mTag, "onDetach()");
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        LogUtil.d(mTag, "onAttach(context:" + context + ")");
        super.onAttach(context);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        LogUtil.d(mTag, "onAttachFragment(childFragment:" + childFragment + ")");
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        LogUtil.d(mTag, "onConfigurationChanged(newConfig:" + newConfig + ")");
        super.onConfigurationChanged(newConfig);
    }
}
