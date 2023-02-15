package org.maxwell.wrongcase.codeoptimization_21.template_factory.cart;

import org.maxwell.wrongcase.codeoptimization_21.template_factory.bo.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 普通用户购物车处理
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/12 00:36
 */
@Service("NormalUserCart")
public class NormalUserCart extends AbstractCart {


    //public Cart process(long userId, Map<Long, Integer> items) {
    //
    //    Cart cart = new Cart();
    //
    //    List<Item> itemList = items.entrySet().stream().map(entry -> {
    //        Item item = new Item();
    //        item.setId(entry.getKey());
    //        item.setPrice(Db.getItemPrice(entry.getKey()));
    //        item.setQuantity(entry.getValue());
    //        return item;
    //    }).collect(Collectors.toList());
    //    cart.setItems(itemList);
    //
    //    itemList.forEach(i -> {
    //        //运费为总价的10%
    //        i.setDeliveryPrice(i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())).multiply(new BigDecimal("0.1")));
    //        //无优惠
    //        i.setCouponPrice(BigDecimal.ZERO);
    //    });
    //
    //    //计算商品总价
    //    cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice()
    //            .multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add));
    //    //计算运费总价
    //    cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
    //    //计算优惠总价
    //    cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
    //    //应付总价=商品总价+运费总价-优惠总价
    //    cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
    //    return cart;
    //}

    @Override
    protected void processCouponPrice(long userId, Item item) {
        item.setCouponPrice(BigDecimal.ZERO);
    }

    @Override
    protected void processDeliveryPrice(long userId, Item item) {
        item.setDeliveryPrice(item.getPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity()))
                .multiply(new BigDecimal("0.1")));
    }



}
