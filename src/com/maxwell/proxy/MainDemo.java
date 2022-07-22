package com.maxwell.proxy;

import com.maxwell.proxy.dynamicproxy.DynamicProxy;
import com.maxwell.proxy.impl.Lz;
import com.maxwell.proxy.impl.Zxzz;
import com.maxwell.proxy.inter.Singer;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 9:33
 */
public class MainDemo {

    public static void main(String[] args) {

//        StaticProxy proxy = new StaticProxy(new Zxzz());
//        proxy.sing(100);
//        proxy.dance(200);

        DynamicProxy dynamicProxy = new DynamicProxy(new Zxzz());
        Singer proxy = dynamicProxy.getProxy();
        proxy.sing(100);
        proxy.dance(200);
        dynamicProxy=new DynamicProxy(new Lz());
        dynamicProxy.getProxy().sing(1000);
        dynamicProxy.getProxy().dance(10000055);

    }


    public void test(){

        Singer[] arrys = new Lz[5];
        arrys[0]=new Zxzz();
        arrys[0].sing(100);

    }

}
