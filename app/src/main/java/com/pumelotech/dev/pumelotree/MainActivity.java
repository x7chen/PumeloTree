package com.pumelotech.dev.pumelotree;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw();
    }
    void draw() {
        Bitmap bitmap = Bitmap.createBitmap(296, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText("American Tomato", 0, 15, paint);
        canvas.drawText("$6.59", 0, 30, paint);
        canvas.drawText("Unit:Kg", 0, 45, paint);
        paint.setTypeface(MyApplication.font);
        paint.setTextSize(14);
        canvas.drawText("中文显示,量子卫星", 60, 60, paint);
        paint.setTextSize(16);
        canvas.drawText("中文显示,量子卫星", 60, 80, paint);
        ImageView layout = (ImageView) findViewById(R.id.canvas_imageView);
        layout.setScaleX(3);
        layout.setScaleY(3);
        layout.setImageBitmap(bitmap);

        ArrayList<Byte> pic = new ArrayList<>();
//        for(int i=0;i<296*16;i++){
//            pic.add((byte)i);
//        }
        for (int col = 0; col < 16; col++) {
            for (int row = 0; row < 296; row++) {
                byte set = 0;
                for (int bit = 0; bit < 8; bit++) {
                    if ((bitmap.getPixel(row, col * 8 + bit) == Color.BLACK)) {
                        set |= (0x80 >> bit);
                    } else {

                        //set |= (0x01<<bit);
                    }
                }
                pic.add(set);
            }

        }
        drawScreen(pic);
    }

    void drawScreen(ArrayList<Byte> src) {
        if (src.size() < 296 * 16) {
            return;
        }
        Bitmap bitmap = Bitmap.createBitmap(296, 128, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        for (int col = 0; col < 16; col++) {
            for (int row = 0; row < 296; row++) {
                for (int bit = 0; bit < 8; bit++) {
                    if (((src.get(col * 296 + row) & (0x80 >> bit)) == 0)) {

                    } else {
                        canvas.drawPoint(row, col * 8 + bit, paint);
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
