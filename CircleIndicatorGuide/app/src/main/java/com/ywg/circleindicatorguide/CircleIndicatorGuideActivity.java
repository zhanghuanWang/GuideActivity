package com.ywg.circleindicatorguide;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CircleIndicatorGuideActivity extends AppCompatActivity {

    public static final int PAGE_COUNT = 4;

    private ViewPager mViewPager;

    private CircleIndicator mCircleIndicator;

    private GuideAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicator_guide);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);

        mAdapter = new GuideAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mCircleIndicator.setViewPager(mViewPager);

        clearOverScrollEffect(mViewPager);

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //TODO
            //status bar background color
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

    static class GuideAdapter extends FragmentPagerAdapter {

        public GuideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GuideFragment.newInstance(position);
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
