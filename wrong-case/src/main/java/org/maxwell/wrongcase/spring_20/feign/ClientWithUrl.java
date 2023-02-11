package org.maxwell.wrongcase.spring_20.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/9 16:48
 */
@FeignClient(name = "clientwithurl", url = "http://127.0.0.1:8081")
public interface ClientWithUrl {

    @GetMapping("/feignaop/server")
    String api();

}
