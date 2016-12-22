package com.pumelotech.dev.pumelotree.utils;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/11/25.
 */
public class JsonGeter {

    public static String getHttpJsonByurlconnection(String fromurl) {
        try {
            Log.v("zms", "使用httpurlconnection");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int len = 0;
            URL url = new URL(fromurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            while ((len = in.read(data)) != -1) {
                os.write(data, 0, len);
            }
            in.close();
            return new String(os.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
