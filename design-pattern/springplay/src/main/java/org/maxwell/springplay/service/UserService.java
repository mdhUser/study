package org.maxwell.springplay.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/29 13:42
 */
@Component
public class UserService {



    @PostConstruct
    public void init(){
        System.out.println("this is init method ...");
    }

    public String out(String str){
        return str;
    }

}
