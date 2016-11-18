package com.pumelotech.dev.pumelotree.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;
import com.pumelotech.dev.pumelotree.transfer.ESLHandler;
import com.pumelotech.dev.pumelotree.transfer.LeConnector;
import com.pumelotech.dev.pumelotree.transfer.callback.ConnectionCallback;
import com.pumelotech.dev.pumelotree.transfer.callback.EslProgressCallback;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
    ProgressBar eslProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        draw();
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

    void draw() {
        GoodsInfo goods = new GoodsInfo();
        goods.Name = "鲜鸡蛋 鸡蛋鲜 天虹售卖";
        goods.Package = "包装：散";
        goods.Unit = "单位：500克";
        goods.Price = "￥6.59";
        goods.Identifier = "12345678901234";
        goods.Supervisor = "周红";
        goods.Origin = "产地：江西";

        Bitmap bitmap = Bitmap.createBitmap(296, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setFakeBoldText(false);
        //paint.setAntiAlias(true);
        //paint.setTypeface(Typeface.DEFAULT);
        paint.setTypeface(MyApplication.font);
        paint.setTextSize(24);
        canvas.drawText(goods.Name, 10, 30, paint);
        paint.setTextSize(48);
        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText(goods.Price, 10, 90, paint);
        paint.setTypeface(MyApplication.font);
        paint.setTextSize(12);
        canvas.drawText(goods.Unit, 180, 52, paint);
        paint.setTypeface(MyApplication.font);
        paint.setTextSize(12);
        canvas.drawText(goods.Package, 180, 70, paint);
        paint.setTextSize(12);
        canvas.drawText(goods.Origin, 180, 88, paint);
        paint.setTextSize(12);
        canvas.drawText("编码 "+goods.Identifier, 180, 106, paint);
        paint.setTextSize(12);
        canvas.drawText("物价员："+goods.Supervisor, 180, 124, paint);
        paint.setTextSize(12);
        canvas.drawText("价格举报电话：12358", 10, 124, paint);
        ImageView layout = (ImageView) findViewById(R.id.canvas_imageView);
        layout.setScaleX(3);
        layout.setScaleY(3);
        layout.setImageBitmap(bitmap);

        ArrayList<Byte> pic = new ArrayList<>();
//        for(int i=0;i<296*16;i++){
//            pic.add((byte)i);
//        }
        for (int row = 0; row < 296; row++) {
            for (int col = 0; col < 16; col++) {

                byte set = 0;
                for (int bit = 0; bit < 8; bit++) {
                    if ((bitmap.getPixel(row, col * 8 + bit) == Color.WHITE)) {
                        set |= (0x80 >> bit);
                    } else {

                        //set |= (0x01<<bit);
                    }
                }
                pic.add(set);
            }

        }
        // drawScreen_t(pic);

        ArrayList<Byte> img = new ArrayList<>();
        for (int i : LabelDemoData.gImage_Z) {
            img.add((byte) i);
        }
        drawScreen_t(pic);
        final ArrayList<Byte> test = pic;
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ESLHandler.getInstance().setScreenData(test.toArray(new Byte[4736]));
                ESLHandler.getInstance().startSendScreenData();
            }
        });
    }



    void drawScreen_t(ArrayList<Byte> src) {
        if (src.size() < 296 * 16) {
            return;
        }
        Bitmap bitmap = Bitmap.createBitmap(296, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        for (int row = 0; row < 296; row++) {
            for (int col = 0; col < 16; col++) {

                for (int bit = 0; bit < 8; bit++) {
                    if (((src.get(col + row * 16) & (0x80 >> bit)) == 0)) {
                        canvas.drawPoint(row, col * 8 + bit, paint);
                    } else {

                    }
                }
            }

        }
        ImageView layout = (ImageView) findViewById(R.id.screen_imageView);
        layout.setScaleX(3);
        layout.setScaleY(3);
        layout.setImageBitmap(bitmap);
    }
}
