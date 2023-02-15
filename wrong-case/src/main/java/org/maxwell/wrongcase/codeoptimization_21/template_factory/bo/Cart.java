package org.maxwell.wrongcase.codeoptimization_21.template_factory.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/12 00:31
 */
@Data
public class Cart {

    //商品清单
    private List<Item> items = new ArrayList<>();
    // 总优惠
    private BigDecimal totalDiscount;
    // 商品总价
    private BigDecimal totalItemPrice;
    // 总运费
    private BigDecimal totalDeliveryPrice;
    //应付总价
    private BigDecimal payPrice;


}
