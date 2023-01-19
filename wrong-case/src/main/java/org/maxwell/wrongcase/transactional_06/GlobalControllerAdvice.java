package org.maxwell.wrongcase.transactional_06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/19 11:23
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> runtimeExceptionHandler(RuntimeException e) {
        return new HashMap<String, String>() {
            {
                put("10001", e.getMessage());
            }
        };
    }


}
