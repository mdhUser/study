package org.maxwell.hmredis.controller;


import cn.hutool.json.JSONUtil;
import org.maxwell.hmredis.dto.Result;
import org.maxwell.hmredis.entity.ShopType;
import org.maxwell.hmredis.service.IShopTypeService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.maxwell.hmredis.utils.RedisConstants.CACHE_SHOP_TYPE_KEY;
import static org.maxwell.hmredis.utils.RedisConstants.CACHE_SHOP_TYPE_TTL;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 虎哥
 */
@RestController
@RequestMapping("/shop-type")
public class ShopTypeController {
    @Resource
    private IShopTypeService typeService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("list")
    public Result queryTypeList() {
        String shopTypeListJsonStr = stringRedisTemplate.opsForValue().get(CACHE_SHOP_TYPE_KEY);
        if (StringUtils.hasText(shopTypeListJsonStr))
            return Result.ok(JSONUtil.toList(shopTypeListJsonStr, ShopType.class));
        else {
            List<ShopType> typeList = typeService
                    .query().orderByAsc("sort").list();
            stringRedisTemplate.opsForValue().set(CACHE_SHOP_TYPE_KEY, JSONUtil.toJsonStr(typeList),CACHE_SHOP_TYPE_TTL, TimeUnit.SECONDS);
            return Result.ok(typeList);
        }
    }
}
