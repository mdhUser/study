package org.maxwell.wrongcase.cache_23.penetration;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/24 16:22
 */

@RestController
public class CachePenetration {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @GetMapping("wrong")
    public String wrong(@RequestParam("id") int id) {
        String key = "user" + id;
        String data = stringRedisTemplate.opsForValue().get(key);
        //无法区分是无效用户还是缓存失效
        if (StringUtils.isEmpty(data)) {
            data = getCityFromDb(id);
            stringRedisTemplate.opsForValue().set(key, data, 30, TimeUnit.SECONDS);
        }
        return data;
    }

    private String getCityFromDb(int id) {
        atomicInteger.incrementAndGet();
        //注意，只有ID介于0（不含）和10000（包含）之间的用户才是有效用户，可以查询到用户信息
        if (id > 0 && id <= 10000) return "userdata";
        //否则返回空字符串
        return "";
    }


}
