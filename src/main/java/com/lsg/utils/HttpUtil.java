package com.lsg.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 * 发出HTTP GET 请求
 * Created by tgdsl on 2016/12/6.
 */
public class HttpUtil  {
    public  static InputStream SendHttpGetRequest(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();//创建一个客户
        HttpGet httpGet = new HttpGet("url");
        try {
            HttpResponse response = httpClient.execute(httpGet);//发出请求并结束服务端响应
            InputStream inputStream = null;
            if (response.getStatusLine().getStatusCode() == 200) {
                inputStream = response.getEntity().getContent();
                httpClient.close();
            }else{
                throw new RuntimeException("请求"+url+"异常："+response.getStatusLine().getStatusCode());
            }
            return inputStream;
        }catch(IOException ioe){
            throw new RuntimeException("请求"+url+"异常");
        }


    }
}
