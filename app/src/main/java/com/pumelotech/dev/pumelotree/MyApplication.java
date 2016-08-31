package com.pumelotech.dev.pumelotree;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.pumelotech.dev.pumelotree.Transfer.LeConnector;

/**
 * Created by Administrator on 2016/8/30.
 */
public class MyApplication extends Application {
    public static String DebugTag = "Pumelo";
    public static Typeface font;
    public static Context context;
    public static LeConnector gLeConnector;
    @Override
    public void onCreate() {
        super.onCreate();
        font = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");
        context = this;
    }
}
