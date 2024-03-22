package org.maxwell.springplay.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Reader;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/23 00:31
 */
@Slf4j
@Component("CSV")
public class CsvParser implements Parser {
    @Override
    public List parse(Reader reader) {
        log.info("用CSV Parser 解析。。。");
        return null;
    }
}
