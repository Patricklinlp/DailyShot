package com.lp.dailyshot.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp.dailyshot.R;
import com.lp.dailyshot.util.ResUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public class TestFragment extends Fragment {

    private String mTitle;
    private View mContentView;
    private TextView mTextView;

    public TestFragment(){
    }

    public TestFragment setTitle(String title) {
        mTitle = title;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_test, container, false);
        mTextView = ResUtil.findViewById(R.id.textView, mContentView);
        return mContentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTextView.setText(mTitle);
        super.onViewCreated(view, savedInstanceState);
    }
}
