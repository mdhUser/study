package org.maxwell.wrongcase.oom_17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/6 21:19
 */
@Slf4j
@RestController
public class WeakHashMapDemoController {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User {
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class UserProfile {
        private User user;
        private String location;
    }


    private Map<User,WeakReference<UserProfile>> cache = new ConcurrentReferenceHashMap<>(100,
            ConcurrentReferenceHashMap.ReferenceType.WEAK);


    //springframework 实现的工具类
    private Map<User,UserProfile> cache2 = new ConcurrentReferenceHashMap<>(100,
            ConcurrentReferenceHashMap.ReferenceType.WEAK);

    @GetMapping("oop/right")
    public void right() {
        String userName = "zhuye";
        //间隔1秒定时输出缓存中的条目数
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache size:{}", cache.size()), 1, 1, TimeUnit.SECONDS);
        LongStream.rangeClosed(1, 200_0000).forEach(i -> {
            User user = new User(userName + i);
            //这次，我们使用弱引用来包装UserProfile
            cache.put(user, new WeakReference<>(new UserProfile(user, "location" + i)));
        });
    }

    @GetMapping("oop/right01")
    public void right01() {
        String userName = "zhuye";
        //间隔1秒定时输出缓存中的条目数
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () -> log.info("cache size:{}", cache2.size()), 1, 1, TimeUnit.SECONDS);
        LongStream.rangeClosed(1, 200_0000).forEach(i -> {
            User user = new User(userName + i);
            //这次，我们使用弱引用来包装UserProfile
            cache2.put(user, new UserProfile(user, "location" + i));
        });
    }
}
