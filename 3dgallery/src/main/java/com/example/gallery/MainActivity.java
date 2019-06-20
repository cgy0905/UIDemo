package com.example.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gallery.anim.MyTransformation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int pagerWidth;
    private List<ImageView> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager = findViewById(R.id.viewPager);
        images = new ArrayList<>();
        /**
         * 为ImageView生成带犹豫倒影的bitmap
         */
        ImageView first = new ImageView(this);
        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.first, MainActivity.this));
        ImageView second = new ImageView(MainActivity.this);
        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.second, MainActivity.this));
        ImageView third = new ImageView(MainActivity.this);
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.third, MainActivity.this));
        ImageView fourth = new ImageView(MainActivity.this);
        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fourth, MainActivity.this));
        ImageView fifth = new ImageView(MainActivity.this);
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fifth, MainActivity.this));
        images.add(first);
        images.add(second);
        images.add(third);
        images.add(fourth);
        images.add(fifth);
        viewPager.setOffscreenPageLimit(3);
        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams params = viewPager.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            params.width = pagerWidth;
        }
        viewPager.setLayoutParams(params);
        viewPager.setPageMargin(-50);
        findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });
        viewPager.setPageTransformer(true, new MyTransformation());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return images.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(images.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = images.get(position);
                container.addView(imageView, position);
                return imageView;
            }
        });
    }
}
