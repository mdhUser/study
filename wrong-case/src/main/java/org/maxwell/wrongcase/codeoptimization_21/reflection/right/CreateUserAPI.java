package org.maxwell.wrongcase.codeoptimization_21.reflection.right;

import lombok.Data;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/14 17:33
 */
@Data
@BankAPI(url = "/bank/createUser", desc = "创建用户接口")
public class CreateUserAPI extends AbstractAPI {

    @BankAPIField(order = 1, type = BankAPIFieldType.S, length = 10)
    private String name;
    @BankAPIField(order = 2, type = BankAPIFieldType.S, length = 18)
    private String identity;
    @BankAPIField(order = 4, type = BankAPIFieldType.S, length = 11)
    private String mobile;
    @BankAPIField(order = 3, type = BankAPIFieldType.N, length = 5)
    private int age;

}
