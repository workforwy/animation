package com.wy.animation.rotate3d.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

public class AlphaPageTransformer implements ViewPager.PageTransformer {
    private float MIN_SCALE = 0.85f;
    private float MIN_ALPHA = 0.5f;

    @Override
    /**
     * transformPage会被当前可见页面和相邻退出屏幕的页面调用
     * view 当前页面
     * position 相对屏幕中心位置的页面 随用户滑动屏幕的大小而变化
     * 取值：0页面充满整个屏幕
     *          0.5页面滑动中间位置 第一页为0.5 第二页为-0.5
     *          1页面从屏幕右侧退出
     *         -1页面从屏幕左侧退出
     */
    public void transformPage(View view, float position) {
        // TODO Auto-generated method stub
        if (position < -1) {// 当前页面离开视野进入左边
            view.setAlpha(0);
        } else if (position <= 1) {
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
            if(position<=0){
                view.setAlpha(1+position);
            }else{
                view.setAlpha(1 - position);
            }
        } else {
            view.setAlpha(0);
        }
    }

}
