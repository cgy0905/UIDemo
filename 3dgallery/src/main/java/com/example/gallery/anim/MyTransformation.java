package com.example.gallery.anim;

import android.graphics.Camera;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author cgy
 * @desctiption
 * @date 2019/5/24 17:45
 */
public class MyTransformation implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA=0.5f;
    private static final float MAX_ROTATE=30;
    private Camera camera=new Camera();

    @Override
    public void transformPage(@NonNull View view, float position) {
        float centerX = view.getWidth() / 2;
        float centerY = view.getHeight() / 2;
        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
        float rotate = 20 * Math.abs(position);
        if (position < -1) {

        } else if (position < 0) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setRotationY(rotate);
        } else if (position >= 0 && position < 1) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setRotationY(-rotate);
        } else if (position >= 1) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setRotationY(-rotate);
        }
    }
}
