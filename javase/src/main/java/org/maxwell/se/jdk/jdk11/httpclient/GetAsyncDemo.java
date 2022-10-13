package org.maxwell.se.jdk.jdk11.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @description:异步请求
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 18:32
 */
public class GetAsyncDemo {

    public static void main(String[] args) {

        testAsyncGet();

    }


    private static final String targetUrl = "localhost:1314/api/v1/pri/user/register";
    private static final URI uri = URI.create(targetUrl);

    //todo 创建一个Get请求
    private final static void testAsyncGet() {

        //创建连接
//      var httpClient=HttpClient.newHttpClient();

        //设置连接超时时间
        var httpClient = HttpClient.newBuilder().build();

        var request = HttpRequest.newBuilder()
                .timeout(Duration.ofMillis(3000)).header("key1", "v1")
                .header("key2", "v2")
                .uri(uri).build();

        try {
            var response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body);
            System.out.println(response.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
