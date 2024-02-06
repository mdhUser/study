package org.maxwell.lg.persistence.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.maxwell.lg.persistence.pojo.Configuration;
import org.maxwell.lg.persistence.pojo.MappedStatement;

import java.io.InputStream;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 21:18
 */
public class XMLMapperBuilder {

    private final Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 解析Mapper.xml
     * @param inputStream
     * @throws DocumentException
     */
    public void parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.selectNodes("//select");
        String namespace = rootElement.attributeValue("namespace");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            String sqlTest = element.getTextTrim();

            //构造MappedStatement
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sqlTest);
            configuration.getMappedStatementMap().put(namespace.concat(".").concat(id),mappedStatement);
        }


    }
}
