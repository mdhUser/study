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

    @Autowired
    private SubUserService subUserService;

    public int getUsersCount(String name) {
        return userDao.findByName(name).size();
    }


    @Transactional(rollbackFor = RuntimeException.class)
    public void createUser(String name) {
        userDao.saveAndFlush(new UserEntity(name));
        if (name.contains("test"))
            throw new RuntimeException("invalid name ！");
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


    @Transactional
    public void createUserAndSubUser(String name) {
        UserEntity user = new UserEntity(name);
        userDao.save(user);
        try {
            subUserService.createSubUserWithException(user);
        } catch (Exception ex) {
            // 捕获异常，防止主方法回滚
            log.error("create sub user error:{}", ex.getMessage());
        }
    }


}
