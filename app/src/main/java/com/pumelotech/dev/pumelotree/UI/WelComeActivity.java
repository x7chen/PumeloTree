package com.pumelotech.dev.pumelotree.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/9/2.
 */
public class WelComeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        taskBackGroud();
        AsyncTask<String,Integer,String> asyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {
                return null;
            }
        };

    }

    void taskBackGroud() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new AsyncTask<String, Integer, String>() {

            @Override
            protected String doInBackground(String... params) {
                MyApplication.font = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");
                try {
                    for (int i = 0; i < 21; i++) {
                        publishProgress(100 * i / 20);
                        Thread.sleep(50);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onProgressUpdate(Integer... params) {
                super.onProgressUpdate(params);
                progressBar.setProgress(params[0]);
            }
        }.execute();
    }
}
