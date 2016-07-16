package com.ywg.verticalguide;

import android.support.v4.view.ViewPager;
import android.view.View;

public class ParallaxTransformer implements ViewPager.PageTransformer {

    private  int id;

    public ParallaxTransformer(int id) {
        this.id = id;
    }

    @Override
    public void transformPage(View view, float position) {
        View localView = view.findViewById(id);
        if ((position < -1.0F) || (position > 1.0F))
            return;
        localView.setTranslationY(-(1.0F * (position * view.getHeight())));
    }
}