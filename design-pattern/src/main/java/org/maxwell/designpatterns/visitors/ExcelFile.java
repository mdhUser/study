package org.maxwell.designpatterns.visitors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/23 14:19
 */
public class ExcelFile extends ResourceFile {
    public ExcelFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}