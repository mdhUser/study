package org.maxwell.se.base.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/19 9:03
 */
public class IoTest {


    public static void main(String[] args) {
        String path="d:/xyz/abc/def/lol2.txt";
        File file = new File(path);
        File parent =file.getParentFile();
        if (!parent.exists())
           parent.mkdirs();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] data={88,89};
            fos.write(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
