package org.maxwell.juc.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/23 17:06
 */
public class Point {

    private int x, y;
    final StampedLock sl = new StampedLock();


    int distanceFromOrigin() {

        //乐观读
        long stamp = sl.tryOptimisticRead();

        //读入局部变量
        int curX =x , curY=y;

        //判断执行读操作期间，是否存在写操作，如果存在，则sl.validate返回false
        if(!sl.validate(stamp)){
            //升级为悲观读锁
            stamp = sl.readLock();
            try {
                curX=x;
                curY=y;
            } finally {
                //释放悲观读锁
                sl.unlockRead(stamp);
            }
        }

        return (int) Math.sqrt(curY*curY+curX*curX);

    }


}
