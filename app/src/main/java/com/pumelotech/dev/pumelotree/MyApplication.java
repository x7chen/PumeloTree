package com.pumelotech.dev.pumelotree;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.pumelotech.dev.pumelotree.transfer.LeConnector;
import com.pumelotech.dev.pumelotree.ui.GoodsInfo;
import com.pumelotech.dev.pumelotree.ui.LabelListActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class MyApplication extends Application {
    public static String DebugTag = "Pumelo";
    public static Typeface font;
    public static Context context;
    public static LeConnector gLeConnector;
    public static LabelListActivity LabelListActivity;
    public static List<GoodsInfo> mLabelList;
    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
    }
}
