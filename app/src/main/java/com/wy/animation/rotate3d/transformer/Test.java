package com.wy.animation.rotate3d.transformer;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class Test implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View v, float p) {
        Log.i("TAG", "--.>>" + v + "--->>>>  " + p);
        if (p < -1) {
            v.setAlpha(0);
        } else if (p <= 1) {
            v.setScaleX(1 - Math.abs(p));
            v.setScaleY(1 - Math.abs(p));
            v.setAlpha(1 - Math.abs(p));
            v.setTranslationX(-480 * p);
        } else {
            v.setAlpha(0);
        }
    }
}
