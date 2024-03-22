package org.maxwell.springplay.factory;


/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/23 00:28
 */
public interface ParserFactory {

    Parser getParser(ContentType contentType);

}
