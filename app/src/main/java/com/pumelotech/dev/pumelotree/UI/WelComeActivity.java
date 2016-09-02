package com.pumelotech.dev.pumelotree.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/9/2.
 */
public class WelComeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        taskBackGroud();
    }

    void taskBackGroud(){

        new AsyncTask<Void,Void,Integer>(){

            @Override
            protected Integer doInBackground(Void... voids) {
                MyApplication.font = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
                return null;
            }
        };
    }
}
