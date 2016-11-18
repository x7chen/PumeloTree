package com.pumelotech.dev.pumelotree.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;
import com.pumelotech.dev.pumelotree.transfer.ESLHandler;
import com.pumelotech.dev.pumelotree.transfer.LeConnector;
import com.pumelotech.dev.pumelotree.transfer.callback.ConnectionCallback;
import com.pumelotech.dev.pumelotree.transfer.callback.EslProgressCallback;
import com.pumelotech.dev.pumelotree.ui.adapter.HidingScrollListener;
import com.pumelotech.dev.pumelotree.ui.adapter.LabelRecyclerAdapter;

import java.util.ArrayList;

public class LabelListActivity extends AppCompatActivity {
    private final static String TAG = MyApplication.DebugTag;
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
    LabelRecyclerAdapter mLabelRecyclerAdapter;
    ArrayList<GoodsInfo> allLabels;
    Toolbar mToolbar;
    ProgressBar eslProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_pigeon_list);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(mToolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_pigeon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        allLabels = LabelDemoData.DemoData;
        MyApplication.mLabelList = allLabels;
        MyApplication.LabelListActivity = this;
        mLabelRecyclerAdapter = new LabelRecyclerAdapter(allLabels);
        recyclerView.setAdapter(mLabelRecyclerAdapter);
//        recyclerView.setOnScrollListener(new HidingScrollListener() {
//            @Override
//            public void onHide() {
//                hideViews();
//            }
//
//            @Override
//            public void onShow() {
//                showViews();
//            }
//        });
        Log.i(TAG, "PigeonListActivity.onCreate()");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android M Permission check
            if (this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("This app needs location access");
                builder.setMessage("Please grant location access so this app can scan ble device.");
                builder.setPositiveButton(android.R.string.ok, null);
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @TargetApi(Build.VERSION_CODES.M)
                    public void onDismiss(DialogInterface dialog) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_COARSE_LOCATION);
                    }
                });
                builder.show();
            }
        }
        LeConnector.getInstance(this).autoConnect("Pumelo-ESL", connectionCallback);
        LeConnector.getInstance(this).setTransferCallback(ESLHandler.getInstance());
        eslProgress = (ProgressBar) findViewById(R.id.esl_progress);
        ESLHandler.getInstance().setEslProgressCallback(eslProgressCallback);
    }

    EslProgressCallback eslProgressCallback = new EslProgressCallback() {
        @Override
        public void updataProgress(int percent) {
            final int fpercent = percent;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    eslProgress.setProgress(fpercent);
                }
            });
        }
    };
    ConnectionCallback connectionCallback = new ConnectionCallback() {
        @Override
        public void onConnectionStateChange(int newState) {

        }

        @Override
        public void onError(String message, int errorCode) {

        }

        @Override
        public void onDeviceNotSupported() {

        }
    };
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "PigeonListActivity.onResume()");
    }

    private void hideViews() {
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.label_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.label_add) {
            Intent intent = new Intent(this,LabelEditActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void updateLabel(GoodsInfo goods) {
        for (GoodsInfo iGoods : allLabels) {
            if (iGoods.Identifier.equals(goods.Identifier)) {
                int label_index = allLabels.indexOf(iGoods);
                allLabels.set(label_index, goods);
            }
        }
        if (mLabelRecyclerAdapter != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLabelRecyclerAdapter.notifyDataSetChanged();
                }
            });

        }
    }

    public void addLabel(GoodsInfo goods) {
        allLabels.add(goods);
        if (mLabelRecyclerAdapter != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLabelRecyclerAdapter.notifyDataSetChanged();
                }
            });

        }
    }
}
