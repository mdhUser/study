package org.maxwell.springplay.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Reader;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/23 00:35
 */
@Component
public class Client {

    @Autowired
    private ParserFactory parserFactory;


    public List getAll(ContentType contentType) {

        Reader reader = null;
        return parserFactory.getParser(contentType).parse(reader);

    }


}
