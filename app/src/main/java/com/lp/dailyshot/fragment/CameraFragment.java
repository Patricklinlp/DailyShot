package com.lp.dailyshot.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lp.dailyshot.R;
import com.lp.dailyshot.util.AppUtil;
import com.lp.dailyshot.util.FileUtil;
import com.lp.dailyshot.util.LogUtil;
import com.lp.dailyshot.util.ResUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public class CameraFragment extends BaseFragment {

    private static final int STATE_TAKE_PHOTO = 1;
    private static final int STATE_SHOW_PHOTO = 2;

    public static final int REQUEST_CODE_CAMERA = 101;

    private View mContentView;
    private ImageView mCameraButton;
    private ImageView mTodayPhoto;

    public CameraFragment() {
        super();
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
        LogUtil.d(mTag, "onCreateView(inflater:" + inflater + ", container:" + container + ", savedInstanceState:" + savedInstanceState + ")");
        mContentView = inflater.inflate(R.layout.fragment_camera, container, false);
        initViews();
        AppUtil.verifyStoragePermissions(getActivity());
        FileUtil.checkAndMakeDirs(AppUtil.getPhotoRootPath());
        return mContentView;
    }

    private void initViews() {
        mCameraButton = ResUtil.findViewById(R.id.camera, mContentView);
        mCameraButton.setOnClickListener(mCameraClickListener);
        mTodayPhoto = ResUtil.findViewById(R.id.today_photo, mContentView);
        mTodayPhoto.setOnLongClickListener(mPhotoLongClickListener);
    }

    private View.OnLongClickListener mPhotoLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            showDeleteConfirmDialog();
            return true;
        }
    };

    private void showDeleteConfirmDialog() {
        AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
        ab.setTitle(ResUtil.getString(R.string.delete_confirm));
        ab.setPositiveButton(ResUtil.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (FileUtil.delete(AppUtil.getTodayPhotoPath())) {
                    Toast.makeText(AppUtil.getApplicationContext(), ResUtil.getString(R.string.delete_success), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AppUtil.getApplicationContext(), ResUtil.getString(R.string.delete_fail), Toast.LENGTH_SHORT).show();
                }
                refreshViewState();
            }
        });
        ab.setNegativeButton(ResUtil.getString(R.string.no), null);
        ab.show();
    }

    private View.OnClickListener mCameraClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startCameraActivity();
        }
    };

    private void startCameraActivity() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse("file://" + AppUtil.getTodayPhotoPath()));
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
        refreshViewState();
        super.onResume();
    }

    private void refreshViewState() {
        int state = FileUtil.exists(AppUtil.getTodayPhotoPath())? STATE_SHOW_PHOTO : STATE_TAKE_PHOTO;
        switchState(state);
    }

    private void switchState(int state) {
        if (state == STATE_SHOW_PHOTO) {
            mCameraButton.setVisibility(View.GONE);
            mTodayPhoto.setImageURI(Uri.parse("file://" + AppUtil.getTodayPhotoPath()));
            mTodayPhoto.setVisibility(View.VISIBLE);
            mTodayPhoto.requestLayout();
        } else {
            mCameraButton.setVisibility(View.VISIBLE);
            mTodayPhoto.setVisibility(View.GONE);
        }
    }
}
