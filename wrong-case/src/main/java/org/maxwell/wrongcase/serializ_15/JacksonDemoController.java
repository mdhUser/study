package org.maxwell.wrongcase.serializ_15;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/31 13:17
 */
@Slf4j
@RestController
public class JacksonDemoController {

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/jackson/wrong")
    public void wrong() throws JsonProcessingException {
        log.info("result :{}", objectMapper.readValue("{\"code\":1234}", APIResult.class));
        log.info("result :{}", objectMapper.readValue("{\"code\":2000}", APIResult.class));
    }


}
