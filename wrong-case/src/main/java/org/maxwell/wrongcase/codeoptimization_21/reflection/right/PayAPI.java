package org.maxwell.wrongcase.codeoptimization_21.reflection.right;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/15 09:57
 */
@BankAPI(url = "/bank/pay",desc = "支付接口")
@Data
public class PayAPI extends AbstractAPI{

    @BankAPIField(order = 1, type = BankAPIFieldType.N, length = 20)
    private long userId;
    @BankAPIField(order = 2, type = BankAPIFieldType.M, length = 10)
    private BigDecimal amount;


}
