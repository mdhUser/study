package org.maxwell.designpatterns.callback.sync;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 10:51
 */
public class B {


    public static void proccess(ICallback callback) {
        System.out.println("----  执行函数前逻辑。。。 ----");
        //回调
        callback.methodToCallback();
        System.out.println("----  执行函数后逻辑。。。 ----");
    }

}
