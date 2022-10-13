package org.maxwell.se.jdk.jdk8.tcs;


import java.io.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/24 19:46
 */
public class TryCatchResource {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "d:/test.txt";
        test(path);


    }

    private static void test(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //jdk9 增加try-catch-resource
        OutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos);
        try (fos;dos) {
            fos.write("我爱你YYJ".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
