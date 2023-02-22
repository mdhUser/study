package org.maxwell.hmredis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.maxwell.hmredis.dto.Result;
import org.maxwell.hmredis.entity.VoucherOrder;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IVoucherOrderService extends IService<VoucherOrder> {

    Result seckillVoucher(Long voucherId);
}
