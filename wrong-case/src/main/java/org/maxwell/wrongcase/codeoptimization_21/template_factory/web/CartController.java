package org.maxwell.wrongcase.codeoptimization_21.template_factory.web;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.codeoptimization_21.template_factory.Db;
import org.maxwell.wrongcase.codeoptimization_21.template_factory.bo.Cart;
import org.maxwell.wrongcase.codeoptimization_21.template_factory.cart.AbstractCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/13 11:02
 */
@Slf4j
@RequestMapping("cart")
@RestController
public class CartController {

    private static final Map<Long, Integer> items = new HashMap<>();

    static {
        items.put(1l, 2);
        items.put(2l, 4);
    }


    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("/right")
    public Cart right(@RequestParam("userId") Long userId) {
        String userCategory = Db.getUserCategory(userId);
        //bean工厂获取具体的购物车（工厂模式/策略模式）
        AbstractCart cart = (AbstractCart) applicationContext.getBean(userCategory + "UserCart");
        return cart.process(userId, items);
    }


}
