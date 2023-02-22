package org.maxwell.hmredis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.maxwell.hmredis.entity.BlogComments;
import org.maxwell.hmredis.mapper.BlogCommentsMapper;
import org.maxwell.hmredis.service.IBlogCommentsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments> implements IBlogCommentsService {

}
