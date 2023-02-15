package org.maxwell.wrongcase.codeoptimization_21.template_factory.cart;

import org.maxwell.wrongcase.codeoptimization_21.template_factory.Db;
import org.maxwell.wrongcase.codeoptimization_21.template_factory.bo.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * VIP 用户购物车
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/13 10:32
 */

@Service("VipUserCart")
public class VipUserCart extends NormalUserCart {

    @Override
    protected void processCouponPrice(long userId, Item item) {
        if (item.getQuantity() > 2) {
            item.setCouponPrice(item.getPrice()
                    .multiply(BigDecimal.valueOf(100 - Db.getUserCouponPercent(userId)).divide(new BigDecimal("100")))
                    .multiply(BigDecimal.valueOf(item.getQuantity() - 2)));
        } else {
            item.setCouponPrice(BigDecimal.ZERO);
        }
    }
}
