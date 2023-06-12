package org.maxwell.juc.forkjoin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

/**
 * 简易版MapReduce
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/5 15:49
 */
public class MapReduce {


    public static void main(String[] args) {
        HashMap<String, Long> hashMap = new HashMap<>() {{
            put("w", 1L);
        }};
        System.out.println(hashMap.putIfAbsent("w", 0L));
    }

    static class MR extends RecursiveTask<Map<String, Long>> {

        private final String[] fc;

        private final int start, end;

        public MR(String[] fc, int from, int to) {
            this.fc = fc;
            this.start = from;
            this.end = to;
        }

        @Override
        protected Map<String, Long> compute() {
            if (end - start == 1) {
                return calc(fc[start]);
            }
            return null;
        }

        /**
         * 统计单词数量
         *
         * @param str
         * @return
         */
        private Map<String, Long> calc(String str) {
            HashMap<String, Long> map = new HashMap<>();
            String[] words = str.split("\\s+");
            for (String word : words) {
                Long ret = map.putIfAbsent(word, 0L);
                if (ret != null)
                    map.put(word, ret + 1);
            }
            return map;
        }

        //合并结果

    }

}
