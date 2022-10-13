package org.maxwell.se.jdk.jdk11.http2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @description: HttpClient http2协议
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 21:27
 */
public class GetHttp2Demo {

    public static void main(String[] args) {

        testHttp2();
    }

    private static final String targetUrl = "https://http2.akamai.com/demo";
    private static final URI uri = URI.create(targetUrl);

    //todo 创建一个Get请求
    private final static void testHttp2() {

        //创建连接
//      var httpClient=HttpClient.newHttpClient();

        //设置连接超时时间
        var httpClient = HttpClient.newBuilder().
        build();

        var request = HttpRequest.newBuilder()
                .timeout(Duration.ofMillis(3000))
                .version(HttpClient.Version.HTTP_2)
                .uri(uri).build();

        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println(response.version());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
