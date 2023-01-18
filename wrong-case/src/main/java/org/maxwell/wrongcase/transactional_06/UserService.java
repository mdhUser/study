package org.maxwell.wrongcase.transactional_06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 14:17
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void createUser(String name) {
        userDao.saveAndFlush(new UserEntity(name));
        if (name.contains("test"))
            throw new RuntimeException("invalid name ！");
    }


    public int findUsers(String name) {
        return userDao.findByName(name).size();
    }


    @Transactional
    public void createUserRight1(String name) {
        try {
            userDao.save(new UserEntity(name));
            throw new RuntimeException("error");
        } catch (Exception ex) {
            log.error("create user failed", ex);
            //处理异常后手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

}
