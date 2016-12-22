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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.pumelotech.dev.pumelotree.MyApplication;
import com.pumelotech.dev.pumelotree.R;
import com.pumelotech.dev.pumelotree.downloader.HttpPostTools;
import com.pumelotech.dev.pumelotree.transfer.ESLHandler;
import com.pumelotech.dev.pumelotree.transfer.LeConnector;
import com.pumelotech.dev.pumelotree.transfer.callback.ConnectionCallback;
import com.pumelotech.dev.pumelotree.transfer.callback.EslProgressCallback;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String TAG = MyApplication.DebugTag;
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


    protected String urlConn() {
        String rev = null;
        try {
            // URL
            URL url = new URL("http://192.168.1.195:8000/read/");
            // HttpURLConnection
            HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();

            ////设置连接属性
            httpconn.setDoOutput(true);//使用 URL 连接进行输出
            httpconn.setDoInput(true);//使用 URL 连接进行输入
            httpconn.setUseCaches(false);//忽略缓存
            httpconn.setRequestMethod("POST");//设置URL请求方法

            Map<String, String> req = new HashMap<>();
            req.put("goods_id", "5");
            req.put("goods_di", "hello");

            String requestString = getRequestData(req, "utf-8").toString();

            //设置请求属性
            //获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
            byte[] requestStringBytes = requestString.getBytes();
            httpconn.setRequestProperty("Content-length", "" + requestStringBytes.length);
            httpconn.setRequestProperty("Content-Type", "application/octet-stream");
            httpconn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpconn.setRequestProperty("Charset", "UTF-8");
//            httpconn.setRequestProperty("goods_id","5");
            //
            String name = URLEncoder.encode("Pumelo", "utf-8");
            httpconn.setRequestProperty("NAME", name);

            //建立输出流，并写入数据
            OutputStream outputStream = httpconn.getOutputStream();
            outputStream.write(requestStringBytes);
            outputStream.close();

            Log.i(TAG, requestString);
            //Thread.sleep(1000);
            if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // InputStreamReader
                InputStreamReader isr = new InputStreamReader(httpconn.getInputStream(), "utf-8");
                int i;
                String content = "";
                // read
                while ((i = isr.read()) != -1) {
                    content = content + (char) i;
                }
                isr.close();
                //设置TextView
                rev = content;
                Log.i(TAG, "连接成功");
            } else {
                Log.i(TAG, "连接失败:" + httpconn.getResponseCode());
            }
            //disconnect
            httpconn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "异常");
        }


        return rev;
    }

    public static StringBuffer getRequestData(Map<String, String> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();        //存储封装好的请求体信息
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);    //删除最后的一个"&"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
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
        canvas.drawText("编码 " + goods.Identifier, 180, 106, paint);
        paint.setTextSize(12);
        canvas.drawText("物价员：" + goods.Supervisor, 180, 124, paint);
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
//                ESLHandler.getInstance().setScreenData(test.toArray(new Byte[4736]));
//                ESLHandler.getInstance().startSendScreenData();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String str = null;
                        String url = "http://192.168.1.195:8000/read/";
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("goods_id", "6");

                        //str = urlConn();
                        str = HttpPostTools.postForm(url, param);
                        if (str != null) {
                            //Log.i(TAG, decodeUnicode(str));
                            Log.i(TAG, ascii2native(str));
                            //Log.i(TAG, str);
                        }
//                        JSONTokener tokener = new JSONTokener(str);
//
//                        JSONObject object = null;
//                        try {
//                            object = (JSONObject) tokener.nextValue();
//                            JSONArray array = object.getJSONArray("employees");
//                            Log.i(TAG, (String) array.getJSONObject(1).get("lastName"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }


                    }
                }).start();

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

    private class CommonException extends Exception {
        CommonException(String str) {
            Log.i("Pumelo", str);
        }
    }


    private static String ascii2native ( String asciicode )
    {
        String[] asciis = asciicode.split ("\\\\u");
        String nativeValue = asciis[0];
        try
        {
            for ( int i = 1; i < asciis.length; i++ )
            {
                String code = asciis[i];
                nativeValue += (char) Integer.parseInt (code.substring (0, 4), 16);
                if (code.length () > 4)
                {
                    nativeValue += code.substring (4, code.length ());
                }
            }
        }
        catch (NumberFormatException e)
        {
            return asciicode;
        }
        return nativeValue;
    }
}
