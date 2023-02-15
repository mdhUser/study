package org.maxwell.wrongcase.codeoptimization_21.template_factory.cart;

import org.maxwell.wrongcase.codeoptimization_21.template_factory.bo.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 内部用户购物车
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/13 10:46
 */
@Service("InternalUserCart")
public class InternalUserCart extends AbstractCart {

    @Override
    protected void processCouponPrice(long userId, Item item) {
        item.setCouponPrice(BigDecimal.ZERO);
    }

    @Override
    protected void processDeliveryPrice(long userId, Item item) {
        item.setDeliveryPrice(BigDecimal.ZERO);
    }
}
