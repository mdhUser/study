package org.maxwell.se.jdk.jdk8.lambda;

import java.util.stream.Stream;

/**
 * @description: parallelStream 并行流
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 15:07
 */
public class LambdaDemo6 {

    public static void main(String[] args) {


        //todo 并行流
//        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
//        list.parallelStream().forEach(l-> System.out.println(l));

//        for (int i = 0; i < 10; i++) {
////            List list = new ArrayList();
//            //要用CopyOnWriteArrayList防止线程阻塞
//            List list = new CopyOnWriteArrayList();
//            IntStream.range(0,100).parallel().forEach(list::add);
//            System.out.println(list.size());
//        }

        //reduce用法(把集合元素按照逻辑不断减少返回唯一元素)
        int value = Stream.of(1, 2, 3, 4, 5).reduce((x, y) -> x + y).get();
        System.out.println("value = " + value);

        int value1 = Stream.of(1, 2, 3, 4, 5).reduce(100, (x, y) -> x + y);
        System.out.println("value1 = " + value1);

        int value2 = Stream.of(125, 489, 23, 54, 4645).reduce((x, y) -> x > y ? x : y).get();
        System.out.println("value2 = " + value2);

    }

}
