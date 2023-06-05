package org.maxwell.juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/26 14:40
 */
public class UnsafeDemo {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        //通过反射获取Unsafe实例
        Field field = Unsafe.class.getDeclaredField("theUnsafe");

        //设置field可访问
        field.setAccessible(true);

        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println("unsafe = " + unsafe);

        //以上操作Unsafe.getUnsafe()可以直接实现

        Demo demo = (Demo) unsafe.allocateInstance(Demo.class);

        Class<? extends Demo> demoClass = demo.getClass();

        //获取Demo字段
        Field str = demoClass.getDeclaredField("str");
        Field i = demoClass.getDeclaredField("i");
        Field staticStr = demoClass.getDeclaredField("staticStr");

        //获取实例变量str和i在对象内存中的偏移量并设置值
        unsafe.putInt(demo, unsafe.objectFieldOffset(i), 1);
        unsafe.putObject(demo, unsafe.objectFieldOffset(str), "Hello Word!");

        //返回Demo.class
        Object staticField = unsafe.staticFieldBase(staticStr);
        System.out.println("staticField = " + staticField);

        //获取静态变量staticStr的偏移量staticOffset
        long staticOffset = unsafe.staticFieldOffset(staticStr);
        System.out.println("staticOffset偏移量：" + staticOffset);

        System.out.println("设置前的Static字段值：" + unsafe.getObject(staticField, staticOffset));

        unsafe.putObject(staticField, staticOffset, "Hello Java!");

        //再次打印staticStr
        System.out.println("设置后的Static字段值： " + unsafe.getObject(staticField, staticOffset));

        //调用toString方法
        System.out.println("输出结果:" + demo);

        byte size = 1;

        //allocateMemory分配内存并获取内存地址memoryAddress
        long memoryAddress = unsafe.allocateMemory(size);
        System.out.println("memoryAddress = " + memoryAddress);
        //直接往内存里写数据
        unsafe.putAddress(memoryAddress, 1000);

        //获取内存地址数据
        long addrData = unsafe.getAddress(memoryAddress);
        System.out.println("addrData = " + addrData);

    }


    static class Demo {

        public Demo() {
            System.out.println("我是Demo类的构造函数，我被人调用创建对象实例啦....");
        }

        private String str;
        private int i;
        private static String staticStr = "Demo_Static";

        @Override
        public String toString() {
            return "Demo{" +
                    "str = '" + str + '\'' +
                    ", i = '" + i + '\'' +
                    ", staticStr = " + staticStr + '\'' +
                    '}';
        }

    }

}
