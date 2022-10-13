package org.maxwell.se.base.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/16 9:26
 */
public class PropertiesDemo {

    private static String username;
    private static String password;


    static {

        Properties properties = new Properties();
        try {
            properties.load(PropertiesDemo.class.getClassLoader().getResourceAsStream("user.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }

    public static void test() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("lover", "Easter");
        properties.store(new FileOutputStream("src/user.properties", true), "This my Lover");
    }

    public static void main(String[] args) {
        System.out.println(username);
        System.out.println(password);
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class ResourceBundleDemo {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("user");
        System.out.println(bundle.getString("lover"));
    }

}