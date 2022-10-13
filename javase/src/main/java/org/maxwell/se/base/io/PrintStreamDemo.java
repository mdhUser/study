package org.maxwell.se.base.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @description: 打印流
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/17 11:15
 */
public class PrintStreamDemo {

    public static void main(String[] args) {
        try (PrintStream printStream = new PrintStream("src/com/maxwell/base/io/print.txt")) {

            printStream.print("你");
            printStream.print("好");
            printStream.println();
            printStream.println("世");
            printStream.println("界!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
