package org.maxwell.springplay.service;

import org.maxwell.springplay.transaction.TransactionUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 21:11
 */
public class TxService {
    @Transactional
    public void saveMessage() {
        TransactionUtils.doAfterTransaction(() -> {
                    System.out.println("do after transaction ...");
                });

    }
}
