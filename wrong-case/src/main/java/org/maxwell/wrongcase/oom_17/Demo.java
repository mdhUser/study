package org.maxwell.wrongcase.oom_17;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.transactional_06.UserDao;
import org.maxwell.wrongcase.transactional_06.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/6 09:59
 */
@Slf4j
@Component
public class Demo {


    private ConcurrentHashMap<String, List<UserDTO>> autoCompleteIndex = new ConcurrentHashMap<>();

    @Autowired
    private UserDao userDao;

    //@PostConstruct
    public void wrong() {
        //initDB();
        userDao.findAll().forEach(e -> {
            int len = e.getName().length();
            for (int i = 0; i < len; i++) {
                String key = e.getName().substring(0, i + 1);
                autoCompleteIndex.computeIfAbsent(key, s -> new ArrayList<>()).add(new UserDTO(e.getName()));
            }
        });
        log.info("autoCompleteIndex size:{} count:{}", autoCompleteIndex.size(), autoCompleteIndex.values().stream()
                .map(List::size).reduce(0, Integer::sum));
    }

    //@PostConstruct
    public void right() {
        Set<UserDTO> set = userDao.findAll().stream().map(user -> new UserDTO(user.getName()))
                .collect(Collectors.toSet());
        set.forEach(dto -> {
            int length = dto.getName().length();
            for (int i = 0; i < length; i++) {
                String key = dto.getName().substring(0, i);
                autoCompleteIndex.computeIfAbsent(key, k -> new ArrayList<>()).add(dto);
            }
        });
        log.info("autoCompleteIndex size:{} count:{}", autoCompleteIndex.size(), autoCompleteIndex.values().stream()
                .map(List::size).reduce(0, Integer::sum));
        //ConcurrentReferenceHashMap<>
    }

    private void initDB() {
        //先保存10000个用户名随机的用户到数据库中
        userDao.saveAll(LongStream.rangeClosed(1, 10000).mapToObj(i -> new UserEntity(i, randomName()))
                .collect(Collectors.toList()));
    }

    /**
     * 随机生成长度为6的英文名称，字母包含 abcdefghij
     *
     * @return
     */
    private String randomName() {
        return String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')).toUpperCase() +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a')) +
                String.valueOf(Character.toChars(ThreadLocalRandom.current().nextInt(10) + 'a'));
    }


}