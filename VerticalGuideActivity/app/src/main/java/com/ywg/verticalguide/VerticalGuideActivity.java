package com.ywg.verticalguide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 视差效果的垂直滑动引导页
 */
public class VerticalGuideActivity extends AppCompatActivity {

    private static final float MIN_SCALE = 0.75f;
    private static final float MIN_ALPHA = 0.75f;

    private Button mBtnEnterMain;

    private VerticalViewPager mVerticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_guide);
        mBtnEnterMain = (Button) findViewById(R.id.btn_enter_main);

        mVerticalViewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);

        mVerticalViewPager.setAdapter(new DemoAdapter(getSupportFragmentManager()));
        mVerticalViewPager.setPageMargin(0);
        //verticalViewPager.setPageMarginDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_green_dark)));

        mVerticalViewPager.setPageTransformer(true, new ParallaxTransformer(R.id.view_scroller));

        mVerticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 2) {
                    mBtnEnterMain.setVisibility(View.VISIBLE);
                }else {
                    mBtnEnterMain.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBtnEnterMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
