package org.maxwell.designpatterns;

import org.junit.Test;
import org.maxwell.designpatterns.singleton.IdGeneratorEnum;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/30 16:51
 */
public class Test01 {

    @Test
    public void testFactory(){
        IdGeneratorEnum.INSTANCE.getId();
    }


    @Test
    public void testStream(){
        Optional<Integer> max = Stream.of("f", "ba", "hello")
                .map(s -> s.length())
                .filter(l -> l <= 3)
                .max((o1, o2) -> o1 - o2);
        System.out.println(max.get());
    }


}
