package com.ywg.guide;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class BgColorChangeGuideActivity extends AppCompatActivity {

    private FrameLayout mRootLayout;

    private ViewPager mViewPager;

    private CircleIndicator mCircleIndicator;

    private SystemBarTintManager mTintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_bgcolor_change_guide);
        mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintEnabled(true);
        mTintManager.setNavigationBarTintEnabled(true);
        applySelectedColor(android.R.color.holo_green_light);//这里给他设置第一个页面的颜色值

        initView();

    }

    private void initView() {
        mRootLayout = (FrameLayout) findViewById(R.id.fl_root);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new GuidePager(this, R.array.guide_icon, R.array.guide_desc));
        mCircleIndicator.setViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int colorBg[] = getResources().getIntArray(R.array.guide_bg);
                ColorShades shades = new ColorShades();
                shades.setFromColor(colorBg[position % colorBg.length])
                        .setToColor(colorBg[(position + 1) % colorBg.length])
                        .setShade(positionOffset);
                mRootLayout.setBackgroundColor(shades.generate());
                applySelectedColor(shades.generate());
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    //设置状态栏颜色，在onPageScrolled里进行背景颜色一样的设置值。
    private void applySelectedColor(int color) {
        mTintManager.setTintColor(color);
    }


}
