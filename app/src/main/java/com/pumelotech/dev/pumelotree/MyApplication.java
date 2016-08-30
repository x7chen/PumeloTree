package com.pumelotech.dev.pumelotree;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Administrator on 2016/8/30.
 */
public class MyApplication extends Application {
    public static Typeface font;
    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        font = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");
        context = this;
    }
}
