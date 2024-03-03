package org.maxwell.mybatis.mapper;

import org.maxwell.mybatis.entity.User;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/9 14:14
 */
public interface UserMapper {

    List<User> findAll();

    int deleteById(Integer id);

}
