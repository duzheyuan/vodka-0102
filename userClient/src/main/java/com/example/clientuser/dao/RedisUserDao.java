package com.example.clientuser.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/11
 * Time: 17:00
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
@FeignClient(value = "redis-server")
public interface RedisUserDao {

    @PostMapping("redis/string/set")
    void redisSet(@RequestParam("key") String key, @RequestParam("value") String value);

    @GetMapping("redis/string/get")
    String redisGet(@RequestParam("key") String key);

    @DeleteMapping("redis/delete/key")
    Boolean redisDelete(@RequestParam("key") String key);

    @DeleteMapping("redis/delete/keys")
    Integer redisDeleteKeys(@RequestParam("keys") List<String> keys);

    @GetMapping("redis/string/has")
    Boolean redisHasKey(@RequestParam("key") String key);

    @GetMapping("redis/string/expire")
    Boolean redisExpire(@RequestParam("key") String key, @RequestParam("timeout") Integer timeout);

    @GetMapping("redis/String/persist")
    Boolean redisPersist(@RequestParam("key") String key);

    @PostMapping("redis/hyperlog/add")
    Integer redisHyperLogAdd(@RequestParam("key") String key, @RequestParam("value") String value);

    @GetMapping("redis/hyperlog/count")
    Integer redisHyperLogCount(@RequestParam("key") String key);

    @PostMapping("redis/zset/add")
    Boolean redisZsetAdd(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("score") Integer score);

    @DeleteMapping("redis/zset/delete")
    public Integer redisZsetRemove(@RequestParam("key") String key, @RequestParam("values") Object values);
}
