package org.maxwell.designpatterns.visitors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/23 14:40
 */
public interface Visitor {

    void visit(PdfFile pdfFile);

    void visit(ExcelFile excelFile);

    void visit(WordFile wordFile);

}
