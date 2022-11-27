package org.maxwell.aop.service;

import org.maxwell.aop.aspect.OperateLogDO;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 19:00
 */
public class SaverOrderConvert implements Convert<SaveOrder> {
    @Override
    public OperateLogDO convert(SaveOrder order) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOrderId(order.id());
        return operateLogDO;
    }
}
