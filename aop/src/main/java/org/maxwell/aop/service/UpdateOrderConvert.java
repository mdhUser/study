package org.maxwell.aop.service;

import org.maxwell.aop.aspect.OperateLogDO;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 19:02
 */
public class UpdateOrderConvert implements Convert<UpdateOrder> {

    @Override
    public OperateLogDO convert(UpdateOrder order) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOrderId(order.orderId());
        return operateLogDO;
    }
}
