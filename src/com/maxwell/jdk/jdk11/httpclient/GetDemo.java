package com.maxwell.jdk.jdk11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @description: Get 请求
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 16:31
 */
public class GetDemo {

    public static void main(String[] args) {

        testGet();

    }


    private static final String targetUrl = "https://www.baidu.com";
    private static final URI uri = URI.create(targetUrl);

    //todo 创建一个Get请求
    private final static void testGet() {

        //创建连接
//      var httpClient=HttpClient.newHttpClient();

        //设置连接超时时间
        var httpClient = HttpClient.newBuilder().
                connectTimeout(Duration.ofMillis(5000)).build();

        var request = HttpRequest.newBuilder()
                .timeout(Duration.ofMillis(3000)).header("key1", "v1")
                .header("key2", "v2")
                .uri(uri).build();

        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}