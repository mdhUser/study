package org.maxwell.wrongcase.serializ_15;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/31 11:31
 */
@Data
public class APIResult {

    private boolean success;
    private int code;

    public APIResult() {
    }

    //指定Jackson序列化构造器
    @JsonCreator
    public APIResult(@JsonProperty("code") int code) {
        this.code = code;
        if (code == 2000) success = true;
        else success = false;
    }

}
