package org.maxwell.lg.persistence.sqlSession;

import java.util.List;
import java.util.Objects;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 21:45
 */
public class DefaultSqlSession implements SqlSession {

    @Override
    public <E> List<E> selectList(String statementId, Objects... params) {

        return null;
    }


}
