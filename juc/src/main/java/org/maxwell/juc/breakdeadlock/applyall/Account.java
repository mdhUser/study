package org.maxwell.juc.breakdeadlock.applyall;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/6 16:29
 */
public class Account {


    //应该是单例
    private final Allocator allocator = Allocator.getInstance();

    private Integer balance;

    public Account(Integer balance) {
        this.balance = balance;
    }

    void transfer(Account target, int amt) {
        // 一次性申请转出账户和转入账户，直到成功
        //while (!allocator.apply(this, target)) ;
        allocator.applyWaitNotify(target, amt);
        try {
            //锁住转出账户
            synchronized (this) {
                //锁住转入账号
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            //释放资源
            allocator.free(this, target);
        }
    }

}
