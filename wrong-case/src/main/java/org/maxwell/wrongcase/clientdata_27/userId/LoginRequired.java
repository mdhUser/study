package org.maxwell.wrongcase.clientdata_27.userId;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/24 17:30
 */
public @interface LoginRequired {

    String sessionKey() default "currentUser";
}
