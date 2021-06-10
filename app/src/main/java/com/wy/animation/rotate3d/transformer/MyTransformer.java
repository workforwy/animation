package com.wy.animation.rotate3d.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

public class MyTransformer implements ViewPager.PageTransformer {
    private float MIN_SCALE = 0.85f;
    private float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View view, float position) {
        // TODO Auto-generated method stub

        if (position < -1) {// 当前页面离开视野进入左边
            view.setRotationY(0);
        } else if (position < 0) {

            view.setRotationY((position) * 90);

        } else if (position == 0) {
            view.setRotationY(0);
        } else if (position < 1) {
            view.setPivotX(1);
            view.setRotationY((position) * 90);
            view.setAlpha(1-position);
            view.setTranslationX(view.getWidth()*-position);
            float
                    scaleFactor=MIN_SCALE+(1-MIN_SCALE)*(1-Math.abs(position));

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        } else if (position == 1) {
            view.setRotationY(0);
        } else {// 当前页面离开视野进入右边
            view.setRotationY(0);
        }
    }
}
