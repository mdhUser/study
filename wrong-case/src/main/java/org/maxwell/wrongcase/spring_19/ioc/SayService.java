package org.maxwell.wrongcase.spring_19.ioc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/7 20:48
 */
@Slf4j
public abstract class SayService {

    List<String> data = new ArrayList<>();

    public void say() {
        data.add(IntStream.rangeClosed(1, 100_0000)
                .mapToObj(__ -> "a")
                .collect(Collectors.joining("")) + UUID.randomUUID());
        log.info("I'm {} size:{}", this, data.size());
    }


}
