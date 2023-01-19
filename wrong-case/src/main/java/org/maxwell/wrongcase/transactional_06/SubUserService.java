package org.maxwell.wrongcase.transactional_06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/19 11:02
 */
@Slf4j
@Service
public class SubUserService {


    @Autowired
    private UserDao userDao;


    /**
     * 被调用时创建独立事务
     *
     * @param entity
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createSubUserWithException(UserEntity entity) {
        log.info("~~~ createSubUserWithExceptionRight start ~~~");
        userDao.save(entity);
        throw new RuntimeException("invalid status");
    }

}
