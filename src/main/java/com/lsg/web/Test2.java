package com.lsg.web;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.misc.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by tgdsl on 2016/12/6.
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();//创建一个客户
        HttpGet httpGet = new HttpGet("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1481616776&di=c2bdcdbdc533ca4e9e10632a1ea62a8b&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.akjunshi.com%2Fupload%2F20161117%2F14793636049423.jpg");
        HttpResponse response = httpClient.execute(httpGet);//发出请求并结束服务端响应
        if(response.getStatusLine().getStatusCode()==200){
            InputStream inputStream = response.getEntity().getContent();
            OutputStream outputStream = new FileOutputStream("D:/x.jpg");
            org.apache.commons.io.IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        }
        httpClient.close();
    }
}
