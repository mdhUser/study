package org.maxwell.lg.dao;

import org.maxwell.lg.entity.User;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/7 20:29
 */
public interface UserDao {

    List<User> findAll();

    User findOne(User user);

}
