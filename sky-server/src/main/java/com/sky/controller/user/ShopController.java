package com.sky.controller.user;


import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/shop")
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {
    public static final String key = "SHOP_STATUS";

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/status")
    @ApiOperation("用户端获取店铺营业状态")
    public Result getStatus() {
        int status = (int) redisTemplate.opsForValue().get(key);
        log.info("获取营业状态：{}", status);
        return Result.success(status);
    }
}
