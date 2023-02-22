package org.maxwell.hmredis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.maxwell.hmredis.dto.Result;
import org.maxwell.hmredis.entity.Voucher;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IVoucherService extends IService<Voucher> {

    Result queryVoucherOfShop(Long shopId);

    void addSeckillVoucher(Voucher voucher);
}
