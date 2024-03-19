package org.maxwell.juc.meituan;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static final int PAGE_SOURCE_A = 1;
    public static final int PAGE_SOURCE_B = 2;

    private static final Map<Integer, Integer> PAGE_SIZE_MAP = new HashMap<>();
    static {
        PAGE_SIZE_MAP.put(PAGE_SOURCE_A, 1);
        PAGE_SIZE_MAP.put(PAGE_SOURCE_B, 2);
    }

    /**
     * 返回尺寸为 height * width 的头像 url
     * 可直接使用
     */
    private static String getUserPicWithTargetSize(int height, int width){
        return String.format("http://userpic_mock h %d w %d", height, width);
    }

    /**
     * 返回页面对应尺寸的头像 url
     */
    private String getUserPicForPage(int pageSource){
        int size = PAGE_SIZE_MAP.getOrDefault(pageSource, 1); // 默认尺寸为1*1
        return getUserPicWithTargetSize(size, size);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.getUserPicForPage(UserService.PAGE_SOURCE_A));
        System.out.println(userService.getUserPicForPage(UserService.PAGE_SOURCE_B));
    }
}
