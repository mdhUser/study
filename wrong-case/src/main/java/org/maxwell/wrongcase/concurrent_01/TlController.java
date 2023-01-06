package org.maxwell.wrongcase.concurrent_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/1 18:02
 */
@RestController
@RequestMapping("/threadLocal")
public class TlController {

    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);


    @GetMapping("/wrong")
    public Map wrong(@RequestParam("userId") Integer userId) {

        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);
        //汇总输出两次查询结果
        String after = Thread.currentThread().getName() + ":" + currentUser.get();
        //汇总输出两次查询结果
        return new HashMap() {
            {
                put("before", before);
                put("after", after);
            }
        };
    }


    @GetMapping("/right")
    public Map right(@RequestParam("userId") Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);
        try {
            //汇总输出两次查询结果
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            Map result = new HashMap(10);
            result.put("before", before);
            result.put("after", after);
            return result;
        } finally {
            currentUser.remove();
        }
    }

}
