package org.maxwell.wrongcase.spring_19.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/7 21:47
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Metrics
    public void createUser(UserEntity entity) {
        userDao.save(entity);
        if (entity.getName().contains("test"))
            throw new RuntimeException("invalid username!");
    }

    public int getUserCount(String name) {
        return userDao.findByName(name).size();
    }

}
