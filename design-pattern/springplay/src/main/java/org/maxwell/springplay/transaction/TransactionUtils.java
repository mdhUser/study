package org.maxwell.springplay.transaction;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 20:44
 */
public class TransactionUtils {

    static class DoTransactionCompletion implements TransactionSynchronization {
        private final Runnable runnable;

        public DoTransactionCompletion(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void afterCompletion(int status) {
            if (status == TransactionSynchronization.STATUS_COMMITTED) {
                this.runnable.run();
            }
        }
    }

    //事务成功后执行的回调函数
    public static void doAfterTransaction(Runnable run) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(new DoTransactionCompletion(run));
        }
    }

}