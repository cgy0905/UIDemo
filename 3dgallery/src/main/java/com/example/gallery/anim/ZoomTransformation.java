package com.example.gallery.anim;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author cgy
 * @desctiption
 * @date 2019/5/24 17:53
 */
public class ZoomTransformation implements ViewPager.PageTransformer {

    private static final float MIN_SCALE=0.85f;
    private static final float MIN_ALPHA=0.5f;

    @Override
    public void transformPage(@NonNull View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();
        if (position < -1) {

        } else if (position <= 1) {
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin-vertMargin/2);
            } else {
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            }
            view.setAlpha(1);
        } else {

        }
    }
}
