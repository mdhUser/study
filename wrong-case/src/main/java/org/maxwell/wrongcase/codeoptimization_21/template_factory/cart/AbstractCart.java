package org.maxwell.wrongcase.codeoptimization_21.template_factory.cart;

import org.maxwell.wrongcase.codeoptimization_21.template_factory.Db;
import org.maxwell.wrongcase.codeoptimization_21.template_factory.bo.Cart;
import org.maxwell.wrongcase.codeoptimization_21.template_factory.bo.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 基类模板
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/12 15:38
 */
public abstract class AbstractCart {

    public Cart process(long userId, Map<Long, Integer> items) {

        Cart cart = new Cart();

        List<Item> itemList = items.entrySet().stream().map(entry -> {
            Item item = new Item();
            item.setId(entry.getKey());
            item.setPrice(Db.getItemPrice(entry.getKey()));
            item.setQuantity(entry.getValue());
            return item;
        }).collect(Collectors.toList());
        cart.setItems(itemList);

        itemList.forEach(i -> {
            processCouponPrice(userId, i);
            processDeliveryPrice(userId, i);
        });

        //计算商品总价
        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算运费总价
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算优惠总价
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //应付总价=商品总价+运费总价-优惠总价
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        return cart;
    }

    //处理商品优惠的逻辑留给子类实现
    protected abstract void processCouponPrice(long userId, Item item);

    //处理配送费的逻辑留给子类实现
    protected abstract void processDeliveryPrice(long userId, Item item);

}