package org.maxwell.wrongcase.codeoptimization_21.template_factory.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/12 00:33
 */
@Data
public class Item {

    //ID
    private Long id;
    //商品数量
    private Integer quantity;
    //商品单价
    private BigDecimal price;
    //商品优惠
    private BigDecimal couponPrice;
    //商品运费
    private BigDecimal deliveryPrice;


}
