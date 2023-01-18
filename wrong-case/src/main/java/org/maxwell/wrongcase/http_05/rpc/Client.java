package org.maxwell.wrongcase.http_05.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/17 15:26
 */
@FeignClient(name = "cl", url = "http://127.0.0.1:8080")
public interface Client {

    @PostMapping("/test/server")
    void server();


}
