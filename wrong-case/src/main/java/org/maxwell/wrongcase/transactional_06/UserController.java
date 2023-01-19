package org.maxwell.wrongcase.transactional_06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 14:23
 */
@Slf4j
@RestController
@RequestMapping("/transaction")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/right")
    public int right(@RequestParam("name") String name) {
        userService.createUser(name);
        return userService.getUsersCount(name);
    }


    @GetMapping("/right1")
    public int right1(@RequestParam("name") String name) {
        userService.createUserRight1(name);
        return userService.getUsersCount(name);
    }


    @GetMapping("/right2")
    public int right2(@RequestParam("name") String name) {
        userService.createUserAndSubUser(name);
        return userService.getUsersCount(name);
    }

}
