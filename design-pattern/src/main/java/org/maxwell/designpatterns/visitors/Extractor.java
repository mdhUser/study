package org.maxwell.designpatterns.visitors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/23 14:20
 */
public class Extractor implements Visitor {

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Extract Pdf.");
    }
    @Override
    public void visit(ExcelFile excelFile) {
        System.out.println("Extract Excel.");
    }
    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Extract Word.");
    }

}
