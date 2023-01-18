package org.maxwell.wrongcase.http_05;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 10:04
 */
@Slf4j
@RestController("http2")
public class HttpClientDemoController {


    private static CloseableHttpClient httpClient;


    static {
        //并发数太小
        //httpClient = HttpClients.custom().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
        httpClient = HttpClients.custom().setMaxConnPerRoute(10).setMaxConnTotal(20).build();
    }

    private int sendRequest(int count, Supplier<CloseableHttpClient> client) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, count).forEach(__ -> {
            threadPool.execute(() -> {
                try (CloseableHttpResponse response = client.get().execute(new HttpGet("http://127.0.0.1:8080/routelimit/server"))) {
                    atomicInteger.addAndGet(Integer.parseInt(EntityUtils.toString(response.getEntity())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        log.info("发送 {} 次请求，耗时 {} ms", atomicInteger.get(), System.currentTimeMillis() - start);
        return atomicInteger.get();
    }


    /**
     * 模拟网络爬虫接口
     *
     * @param count
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/fetch")
    public int wrong(@RequestParam(value = "count", defaultValue = "10") int count) throws InterruptedException {
        return sendRequest(count, () -> httpClient);
    }


}
