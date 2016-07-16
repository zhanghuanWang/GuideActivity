package com.ywg.circleindicatorguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageGuideFragment extends Fragment  {

    private int[] imageResIds = {R.drawable.qunzu_feature_bg1, R.drawable.qunzu_feature_bg2, R.drawable.qunzu_feature_bg3,R.drawable.qunzu_feature_bg1};
    private ImageView mImageView;

    public ImageGuideFragment() {
        // Required empty public constructor
    }

    public static ImageGuideFragment newInstance(int id) {
        ImageGuideFragment fragment = new ImageGuideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mImageView = new ImageView(container.getContext());
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(imageResIds[getArguments().getInt("Id")]);
        return mImageView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}