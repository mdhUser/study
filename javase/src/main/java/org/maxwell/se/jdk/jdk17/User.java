package org.maxwell.se.jdk.jdk17;

/**
 * @description: Record测试
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/28 10:41
 */
public record User(String name,char sex) {

    public final static int age;

    static {
        age=1;
    }

    public static int getAge() {
        return age;
    }

}

class Test{

    public static void main(String[] args) {

        User user = new User("张三",'男');
        System.out.println(user.name()+","+user.sex());
        System.out.println(User.getAge());

    }


}