package org.maxwell.se.jdk.jdk11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @description: Post 请求
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 16:31
 */
public class PostDemo {

    public static void main(String[] args) {

        testPost();

    }


    private static final String targetUrl = "http://169.254.160.30:1314/api/v1/pri/user/register";
    private static final URI uri = URI.create(targetUrl);

    //todo 创建一个Post请求
    private final static void testPost() {

        //设置连接超时时间 connect timeout
        var httpClient = HttpClient.newBuilder().
                connectTimeout(Duration.ofMillis(5000)).build();

        var request = HttpRequest.newBuilder().uri(uri)

                //json格式请求
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{"+
                        "\"name\":\"mdh\",\n" +
                        "\"phone\":\"19850866685\",\n" +
                        "\"pwd\":\"271511@da\"\n" +
                        "}"))
                .build();
//        form表单则使⽤下⾯配置
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .POST(HttpRequest.BodyPublishers.ofString("name=mdh&phone=19850866685&pwd=1234567890"))
//                .build();

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