package com.pumelotech.dev.pumelotree.downloader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class HttpPostTools {
    static public String postForm(String actionURL, HashMap<String, String> parameters) {
        String end = "\r\n";
        String twoHyphens = "--";
        String boundary = "---------------------------7e0dd540448";
        String response = "";
        try {
            URL url = new URL(actionURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //发送post请求需要下面两行
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //设置请求参数
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            //获取请求内容输出流
            DataOutputStream ds = new DataOutputStream(connection.getOutputStream());
            //开始写表单格式内容
            //写参数
            Set<String> keys = parameters.keySet();
            for (String key : keys) {
                ds.writeBytes(twoHyphens + boundary + end);
                ds.writeBytes("Content-Disposition: form-data; name=\"");
                ds.write(key.getBytes());
                ds.writeBytes("\"" + end);
                ds.writeBytes(end);
                ds.write(parameters.get(key).getBytes());
                ds.writeBytes(end);
            }
            ds.flush();
            try {
                //获取URL的响应
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String s = "";
                String temp = "";
                while ((temp = reader.readLine()) != null) {
                    s += temp;
                }
                response = s;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("No response get!!!");
            }
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Request failed!");
        }
        return response;
    }


}