package com.pumelotech.dev.pumelotree.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.pumelotech.dev.pumelotree.MyApplication;


import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/18.
 */
public class LabelDrawer {
    Bitmap bitmap;
    ArrayList<Byte> labelData;
    public LabelDrawer(GoodsInfo goods){
        bitmap = Bitmap.createBitmap(296, 128, Bitmap.Config.ARGB_8888);
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
        canvas.drawText("￥"+goods.Price, 10, 90, paint);
        paint.setTypeface(MyApplication.font);
        paint.setTextSize(12);
        canvas.drawText("单位:"+goods.Unit, 180, 52, paint);
        paint.setTypeface(MyApplication.font);
        paint.setTextSize(12);
        canvas.drawText("包装:"+goods.Package, 180, 70, paint);
        paint.setTextSize(12);
        canvas.drawText("产地:"+goods.Origin, 180, 88, paint);
        paint.setTextSize(12);
        canvas.drawText("编码:" + goods.Identifier, 180, 106, paint);
        paint.setTextSize(12);
        canvas.drawText("物价员:" + goods.Supervisor, 180, 124, paint);
        paint.setTextSize(12);
        canvas.drawText("价格举报电话：12358", 10, 124, paint);
        labelData = new ArrayList<>();
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
                labelData.add(set);
            }
        }

    }

    public Bitmap getBitMap(){
        return bitmap;
    }
    public ArrayList<Byte> getLabelDataList()
    {
        return labelData;
    }
    public Byte[] getLabelData(){
        return labelData.toArray(new Byte[4736]);
    }
}
