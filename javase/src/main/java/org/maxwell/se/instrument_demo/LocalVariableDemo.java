package org.maxwell.se.instrument_demo;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/31 10:38
 */
public class LocalVariableDemo {

    public static void main(String[] args) {
//        MyClass myClass = new MyClass();
//        myClass.myMethod();
    }

//    private static class MyClass {
//        public void myMethod() {
//            int x = 10;
//            String message = "Hello, world!";
//            printLocalVariables();
//        }
//
//        private void printLocalVariables() {
//            try {
//                Instrumentation inst = MyInstrumentation.getInstrumentation();
//                Object[] locals = (Object[]) inst.getThreadLocalMap().get(Thread.currentThread());
//                Class<?> threadLocalMapClass = Class.forName("java.lang.ThreadLocal$ThreadLocalMap");
//                Field tableField = threadLocalMapClass.getDeclaredField("table");
//                tableField.setAccessible(true);
//                Object[] table = (Object[]) tableField.get(locals[0]);
//                Field valueField = table[0].getClass().getDeclaredField("value");
//                valueField.setAccessible(true);
//                System.out.println(valueField.get(table[0]));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
