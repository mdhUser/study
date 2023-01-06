package org.maxwell.wrongcase.concurrent_02;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/5 11:17
 */
public interface OrderService {

    boolean createOrder(List<Item> order);


    List<Item> createCart();

}
