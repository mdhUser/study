package org.maxwell.wrongcase.spring_19.aop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 14:14
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByName(@Param("name") String name);


}
