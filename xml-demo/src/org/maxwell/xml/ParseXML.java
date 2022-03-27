package org.maxwell.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 17:45
 */
public class ParseXML {

    public static void main(String[] args) throws DocumentException {
            //1. 创建SaxReader解析器对象
            SAXReader saxReader = new SAXReader();
            //2. 读取目标xml文件
            Document document = saxReader.read(new File("xml-demo/src/bookshelfxsd.xml"));
            //3. 解析
            //获得xml文件的根标签(xml有且仅有一个根标签)
            //元素: 开标签到闭标签之间的所有内容
            Element rootElement = document.getRootElement();
            //获得根标签中所有的book子标签
            List<Element> bookList = rootElement.elements("book");
            //遍历所有的book元素
            for (Element book : bookList) {
                //获得book的id属性所对应的值
//                String id = book.attributeValue("id");
                //获得book子标签name的内容
                String name = book.elementText("name");
                String author = book.elementText("author");
                String sale = book.elementText("sale");
                System.out.println( name + "," + author + "," + sale);
            }
        }
    }
