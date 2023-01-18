package org.maxwell.wrongcase.connection_04;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.util.TimeValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/16 11:00
 */
@Slf4j
@RestController
public class HttpClientDemoController {


    private static CloseableHttpClient httpClient;

    static {
        httpClient = HttpClients.custom()
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .evictIdleConnections(TimeValue.of(60, TimeUnit.SECONDS))
                .build();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error("~~~ 关闭出错：{} ~~~", e.getMessage());
            }
        }));
    }

    @GetMapping("/testHttp/wrong")
    public String wrong() {
        CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .evictIdleConnections(TimeValue.of(60, TimeUnit.SECONDS))
                .build();
        try (CloseableHttpResponse response = client.execute(new HttpGet("http://127.0.0.1:8080/testEvent1"))) {
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/testHttp/right")
    public String right() {
        try (CloseableHttpResponse response = httpClient.execute(new HttpGet("http://127.0.0.1:8080/testEvent1"))) {
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/testHttp/wrong2")
    public String wrong2() {
        try (CloseableHttpClient client = HttpClients.custom()
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .evictIdleConnections(TimeValue.of(60, TimeUnit.SECONDS)).build();
             CloseableHttpResponse response = client.execute(new HttpGet("http://127.0.0.1:8080/testEvent1"))) {
            return EntityUtils.toString(response.getEntity());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
