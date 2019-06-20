package com.example.uidemo;

import android.content.Context;

/**
 * @author cgy
 * @desctiption px和dp相互抓换
 * @date 2019/5/23 17:19
 */
public class DensityUtils {

    public static int dp2px(Context context, float dp) {
        //获取设备密度
        float density = context.getResources().getDisplayMetrics().density;
        int px = (int) (dp * density + 0.5);
        return px;
    }

    public static float px2dp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        float dp = px / density;
        return dp;
    }
}
