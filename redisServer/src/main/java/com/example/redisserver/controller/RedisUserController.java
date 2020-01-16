package com.example.redisserver.controller;


import com.example.redisserver.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/11
 * Time: 16:31
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@RestController
public class RedisUserController {
    @Autowired
    private RedisUserService redisUserService;

    @PostMapping("redis/string/set")
    public void redisSet(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisUserService.redisSet(key, value);
    }

    @GetMapping("redis/string/get")
    public String redisGet(@RequestParam("key") String key) {
        return redisUserService.redisGet(key);
    }

    @DeleteMapping("redis/delete/key")
    public Boolean redisDelete(@RequestParam("key") String key) {
        return redisUserService.redisDelete(key);
    }

    @DeleteMapping("redis/delete/keys")
    public Integer redisDeleteKeys(@RequestParam("keys") List<String> keys) {
        return redisUserService.redisDeleteKeys(keys);
    }

    @GetMapping("redis/string/has")
    public Boolean redisHasKey(@RequestParam("key") String key) {
        return redisUserService.redisHasKey(key);
    }

    @GetMapping("redis/string/expire")
    public Boolean redisExpire(@RequestParam("key") String key, @RequestParam("timeout") Integer timeout) {
        return redisUserService.redisExpire(key, timeout);
    }

    @GetMapping("redis/String/persist")
    public Boolean redisPersist(@RequestParam("key") String key) {
        return redisUserService.redisPersist(key);
    }

    @PostMapping("redis/hyperlog/add")
    public Integer redisHyperLogAdd(@RequestParam("key") String key, @RequestParam("value") String value) {
        return redisUserService.redisHyperLogAdd(key, value);
    }

    @GetMapping("redis/hyperlog/count")
    public Integer redisHyperLogCount(@RequestParam("key") String key) {
        return redisUserService.redisHyperLogCount(key);
    }

    @PostMapping("redis/zset/add")
    public Boolean redisZsetAdd(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("score") Integer score) {
        return redisUserService.redisZsetAdd(key, value, score);
    }

    @DeleteMapping("redis/zset/delete")
    public Integer redisZsetRemove(@RequestParam("key") String key, @RequestParam("values") Object values) {
        return redisUserService.redisZsetRemove(key, values);
    }
}
