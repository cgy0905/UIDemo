package com.example.gallery.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * @author cgy
 * @desctiption
 * @date 2019/5/24 17:41
 */
public class MyAnimation extends Animation {

    private float centerX;
    private float cneterY;
    private int duration;
    private float rotate;
    private Camera camera = new Camera();

    public MyAnimation(float x, float y, int duration, float rotate) {
        centerX = x;
        cneterY = y;
        this.duration = duration;
        this.rotate = rotate;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(duration);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        camera.save();
        camera.rotateY(rotate * (interpolatedTime));
        Matrix matrix = t.getMatrix();
        camera.getMatrix(matrix);
        matrix.postTranslate(-centerX, -cneterY);
        matrix.postTranslate(centerX, cneterY);
        camera.restore();
    }
}
