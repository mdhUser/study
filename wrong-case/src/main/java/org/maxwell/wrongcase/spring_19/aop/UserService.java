package org.maxwell.wrongcase.spring_19.aop;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.transactional_06.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/7 21:47
 */
@Slf4j
@Service
public class UserService {
    public void createUser(UserEntity entity) {

    }

    public int getUserCount(String name) {
        return 0;
    }
}
