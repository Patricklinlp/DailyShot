package com.lp.dailyshot.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lp.dailyshot.R;
import com.lp.dailyshot.util.AppUtil;
import com.lp.dailyshot.util.LogUtil;
import com.lp.dailyshot.util.ResUtil;

import java.io.File;
import java.util.Date;

/**
 * Created by Patrick on 2017/10/22.
 */

public class CameraFragment extends BaseFragment {

    private View mContentView;
    private ImageView mCameraButton;
    private ImageView mTodayPhoto;
    private String mFilePath = android.os.Environment.getExternalStorageDirectory() + "/dailyShot/Camera/";
    private String mTodayFileName;
    public static final int REQUEST_CODE_CAMERA = 101;

    public CameraFragment() {
        super();
        mTag = "CameraFragment";
    }

    @Override
    public String getTitle() {
        return ResUtil.getString(R.string.tab_name_today);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_camera, container, false);
        mCameraButton = ResUtil.findViewById(R.id.camera, mContentView);
        mCameraButton.setOnClickListener(mCameraClickListener);
        mTodayPhoto = ResUtil.findViewById(R.id.today_photo, mContentView);

        AppUtil.verifyStoragePermissions(getActivity());
        checkDir(mFilePath);
        return mContentView;
    }

    private View.OnClickListener mCameraClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startCameraActivity();
        }
    };

    private void checkDir(String filePath) {
        File file = new File(mFilePath);
        LogUtil.d(mTag, "file exists:" + file.exists());
        if (file.exists()) {
            return;
        }
        LogUtil.d(mTag, "file.isDirectory:" + file.isDirectory());
        if (file.isDirectory()) {
            LogUtil.d(mTag, "file mkdirs:" + filePath);
            file.mkdirs();
        }
        file.mkdirs();
    }

    private void startCameraActivity() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse("file://" + mFilePath + new Date().getDay() + ".jpg"));
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        mTodayFileName = mFilePath + new Date().getDay() + ".jpg";
        if (new File(mTodayFileName).exists()) {
            mCameraButton.setVisibility(View.GONE);
            mTodayPhoto.setImageURI(Uri.parse(mTodayFileName));
            mTodayPhoto.setVisibility(View.VISIBLE);
        } else {
            mCameraButton.setVisibility(View.VISIBLE);
            mTodayPhoto.setVisibility(View.GONE);
        }
        super.onResume();
    }
}
