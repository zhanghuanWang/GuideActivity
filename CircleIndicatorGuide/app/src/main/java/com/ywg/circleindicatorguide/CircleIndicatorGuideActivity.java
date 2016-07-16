package com.ywg.circleindicatorguide;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 底部小圆点指示器 动图显示
 */
public class CircleIndicatorGuideActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PAGE_COUNT = 4;

    private ViewPager mViewPager;

    private CircleIndicator mCircleIndicator;

    private GuideAdapter mAdapter;

    private Button mBtnSkip;

    private Button mBtnLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicator_guide);

        mBtnSkip = (Button) findViewById(R.id.btn_skip);
        mBtnLaunch = (Button) findViewById(R.id.btn_launch);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);

        mAdapter = new GuideAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mCircleIndicator.setViewPager(mViewPager);

        clearOverScrollEffect(mViewPager);

        mBtnSkip.setOnClickListener(this);
        mBtnLaunch.setOnClickListener(this);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //TODO
            //status bar background color
            if (position == (PAGE_COUNT - 1)) {
                mBtnLaunch.setVisibility(View.VISIBLE);
            }else{
                mBtnLaunch.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    void clearOverScrollEffect(View view) {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {
            view.setOverScrollMode(View.OVER_SCROLL_NEVER);
            view.setHorizontalFadingEdgeEnabled(false);
            view.setVerticalFadingEdgeEnabled(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())  {
            case R.id.btn_skip:

                break;
            case R.id.btn_launch:

                break;
        }
    }

    public class GuideAdapter extends FragmentPagerAdapter {

        public GuideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GifGuideFragment.newInstance(position);
             //return ImageGuideFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        mViewPager.addOnPageChangeListener(onPageChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewPager.removeOnPageChangeListener(onPageChangeListener);
    }
}
