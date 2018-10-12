package com.mt.demo.redissentinel.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebController
 *
 * @author MT.LUO
 * 2018/10/12 15:59
 * @Description:
 */
@Slf4j
@RestController
public class WebController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test")
    public String test(@RequestParam String key, @RequestParam String value) {
        ValueOperations<String, String> stringRedis = redisTemplate.opsForValue();
        stringRedis.set(key, value);

        return stringRedis.get(key);
    }

}
