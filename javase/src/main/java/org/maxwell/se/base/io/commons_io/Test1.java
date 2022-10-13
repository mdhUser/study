package org.maxwell.se.base.io.commons_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/17 11:44
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        File src = new File("D:\\lz\\图片\\海边.jpg");
        File newSrc = new File("src/com/maxwell/design_patterns");

        //todo 拷贝文件
        FileUtils.copyFileToDirectory(src, newSrc);
        //todo 拷贝文件夹
        FileUtils.copyDirectoryToDirectory(new File("D:\\lz"),new File("src/com/maxwell/base/io/commons_io"));

    }
}
