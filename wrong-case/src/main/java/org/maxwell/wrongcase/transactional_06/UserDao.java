package org.maxwell.wrongcase.transactional_06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 14:14
 */
public interface UserDao extends JpaRepository<UserEntity, Long> {


    List<UserEntity> findByName(@Param("name") String name);


}
