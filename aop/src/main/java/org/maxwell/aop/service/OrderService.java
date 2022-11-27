package org.maxwell.aop.service;

import org.maxwell.aop.annotations.RecordOperate;
import org.springframework.stereotype.Service;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 18:30
 */
@Service
public class OrderService {

    @RecordOperate(desc = "保存订单", convert = SaverOrderConvert.class)
    public boolean saveOrder(SaveOrder order) {
        System.out.println("save order id:" + order.id());
        return true;
    }

    @RecordOperate(desc = "更新订单", convert = UpdateOrderConvert.class)
    public boolean updateOrder(UpdateOrder order) {
        System.out.println("save order id:" + order.orderId());
        return true;
    }

}
