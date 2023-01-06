package org.maxwell.wrongcase.concurrent_01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/1 21:58
 */
@Slf4j
@RestController
public class CopyOnWriteListDemo {

    private static final int LOOP_COUNT = 100000;

    @GetMapping("/write")
    public Map testWrite() {

        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Write:copyOnWriteArrayList");
        //循环100000次并发往CopyOnWriteArrayList写入随机元素
        IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(__ -> copyOnWriteArrayList.add(ThreadLocalRandom.current().nextInt(LOOP_COUNT)));
        stopWatch.stop();

        stopWatch.start("Write:synchronizedList");
        //循环100000次并发往加锁的ArrayList写入随机元素
        IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(__ -> synchronizedList.add(ThreadLocalRandom.current().nextInt(LOOP_COUNT)));
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return new HashMap() {
            {
                put("copyOnWriteArrayList", copyOnWriteArrayList.size());
                put("synchronizedList", synchronizedList.size());
            }
        };
    }

    private void addAll(List<Integer> list) {
        list.addAll(IntStream.rangeClosed(1, 1000000).boxed().toList());
    }


    @GetMapping("/read")
    public Map testRead() {

        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        //填充数据
        addAll(copyOnWriteArrayList);
        addAll(synchronizedList);

        StopWatch stopWatch = new StopWatch();
        int count = copyOnWriteArrayList.size();
        int loopCount = 1000000;
        stopWatch.start("Read:copyOnWriteArrayList");
        //循环1000000次并发从CopyOnWriteArrayList随机查询元素
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> copyOnWriteArrayList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();

        stopWatch.start("Read:synchronizedList");
        //循环1000000次并发从加锁的ArrayList随机查询元素
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> synchronizedList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return new HashMap() {
            {
                put("copyOnWriteArrayList", copyOnWriteArrayList.size());
                put("synchronizedList", synchronizedList.size());
            }
        };
    }

}
