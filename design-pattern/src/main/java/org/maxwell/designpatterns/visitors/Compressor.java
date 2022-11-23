package org.maxwell.designpatterns.visitors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/23 14:43
 */
public class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Compressor Pdf.");
    }

    @Override
    public void visit(ExcelFile excelFile) {
        System.out.println("Compressor Excel.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Compressor Word.");
    }
}
