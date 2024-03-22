package org.maxwell.springplay.factory;

import java.io.Reader;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/23 00:27
 */
public interface Parser {

    List parse(Reader reader);

}
