package org.maxwell.hmredis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.maxwell.hmredis.entity.UserInfo;
import org.maxwell.hmredis.mapper.UserInfoMapper;
import org.maxwell.hmredis.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
