package com.ywg.verticalguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 垂直滑动引导页
 */
public class VerticalGuideActivity extends AppCompatActivity {

    private static final float MIN_SCALE = 0.75f;
    private static final float MIN_ALPHA = 0.75f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_guide);
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);

        verticalViewPager.setAdapter(new DemoAdapter(getSupportFragmentManager()));
        verticalViewPager.setPageMargin(0);
        //verticalViewPager.setPageMarginDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_green_dark)));

        verticalViewPager.setPageTransformer(true, new ParallaxTransformer(R.id.view_scroller));
    
    }

}
