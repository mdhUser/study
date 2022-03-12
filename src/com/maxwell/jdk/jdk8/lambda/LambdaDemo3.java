package com.maxwell.jdk.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 流操作 map&filter
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 12:53
 */
public class LambdaDemo3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("springboot教程", "微服务教程", "并发编程",
                "redis教程", "消息队列教程");

        List<String> result = list.stream().map(obj -> "在小滴课堂学习" + obj).collect(Collectors.toList());
        result.forEach(l -> System.out.println(l));

        System.out.println("============================");

        List<User> users = new ArrayList<>();
        users.add(new User(1, "小猫", "jsakhjia1"));
        users.add(new User(2, "小滴", "sdaf24y8"));
        users.add(new User(3, "小应", "dwqdfw786"));
        users.add(new User(4, "小周", "18923566"));
        users.add(new User(5, "小翟", "达到fdfdf"));

        List<UserDTO> userDTOS = users.
                stream()
                .map(u ->
                        new UserDTO(u.getId(), u.getName())).collect(Collectors.toList());

        System.out.println("userDTOS = " + userDTOS);

        List<User> result1 = users.stream().filter(u->u.getPwd().length()>8).collect(Collectors.toList());
        System.out.println(result1);

    }


}


class User {

    private int id;
    private String name;
    private String pwd;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

class UserDTO {

    private int userId;
    private String userName;

    public UserDTO() {

    }

    public UserDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}