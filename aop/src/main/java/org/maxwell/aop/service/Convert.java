package org.maxwell.aop.service;

import org.maxwell.aop.aspect.OperateLogDO;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/27 18:54
 */
public interface Convert<P> {

    OperateLogDO convert(P param);

}
