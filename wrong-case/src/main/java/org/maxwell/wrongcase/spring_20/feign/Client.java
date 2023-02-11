package org.maxwell.wrongcase.spring_20.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/9 15:52
 */
@FeignClient(name = "client")
public interface Client {

    @GetMapping("/feignaop/server")
    String api();

}
