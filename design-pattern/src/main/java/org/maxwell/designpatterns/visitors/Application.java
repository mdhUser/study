package org.maxwell.designpatterns.visitors;


import java.util.Arrays;
import java.util.List;

/**
 * @author Maxwell
 * @description: 访问者模式
 * @email: maodihui@foxmail.com
 * @date: 2022/11/23 14:24
 */
public class Application {

    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        Compressor compressor = new Compressor();
        List<ResourceFile> resourceFiles = Arrays.asList(new PdfFile("a.pdf"),
                new WordFile("b.word"),
                new ExcelFile("c.excl"));
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
            resourceFile.accept(compressor);
        }
    }

}