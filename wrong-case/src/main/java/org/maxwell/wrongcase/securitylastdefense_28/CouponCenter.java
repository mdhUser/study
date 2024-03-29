package org.maxwell.wrongcase.securitylastdefense_28;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CouponCenter {
    //用于统计发了多少优惠券
    AtomicInteger totalSent = new AtomicInteger(0);
    public void sendCoupon(Coupon coupon) {
        if (coupon != null)
            totalSent.incrementAndGet();
    }

    public int getTotalSentCoupon() {
        return totalSent.get();
    }

    //没有任何限制，来多少请求生成多少优惠券
    public Coupon generateCouponWrong(long userId, BigDecimal amount)              {
        return new Coupon(userId, amount);
    }
}