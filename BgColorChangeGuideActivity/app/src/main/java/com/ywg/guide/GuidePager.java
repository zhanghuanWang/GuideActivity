package com.ywg.guide;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GuidePager extends PagerAdapter {

    private String[] mDescs;

    private TypedArray mIcons;

    private Context mContext;

    private LayoutInflater mInflater;

    public GuidePager(Context context, int icoImage, int des) {
        mDescs = context.getResources().getStringArray(des);
        mIcons = context.getResources().obtainTypedArray(icoImage);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mIcons.length();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(R.layout.layout_splash_page, container, false);
        ImageView mImage = (ImageView) view.findViewById(R.id.iv_img);
        TextView mTextView = (TextView) view.findViewById(R.id.tv_desc);
        Button mLaunchButton = (Button) view.findViewById(R.id.btn_launch);
        mImage.setImageResource(mIcons.getResourceId(position, 0));
        mTextView.setText(mDescs[position]);
        if (position == getCount() - 1) {
            mLaunchButton.setVisibility(View.VISIBLE);
        } else {
            mLaunchButton.setVisibility(View.GONE);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}