package com.lsg.web;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;
import java.io.InputStream;

public class Test  {

    public static void main(String[] args) throws IOException {
        //创建一个可以发出请求的客户
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个GET请求。
        HttpGet httpGet = new HttpGet("http://www.kaishengit.com");
        //发出请求并接受服务端响应
        HttpResponse response = httpClient.execute(httpGet);
        //获取状态码
        int statusCode  = response.getStatusLine().getStatusCode();
        //获取响应输出流
        InputStream inputStream = response.getEntity().getContent();
        if(statusCode==200){
            String result = IOUtils.toString(inputStream,"UTF-8");
            inputStream.close();
            System.out.println(result);
        }
        httpClient.close();
    }

}
