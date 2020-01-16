package com.example.redisserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/11
 * Time: 14:57
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
public class RedisUserDaoImpl implements RedisUserDao {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void redisSet(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String redisGet(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean redisDelete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Integer redisDeleteKeys(List<String> keys) {
        return redisTemplate.delete(keys).intValue();
    }

    @Override
    public Boolean redisHasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Boolean redisExpire(String key, Integer timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.MINUTES);
    }

    @Override
    public Boolean redisPersist(String key) {
        return redisTemplate.persist(key);
    }

    @Override
    public Integer redisHyperLogAdd(String key, String value) {
        return redisTemplate.opsForHyperLogLog().add(key, value).intValue();
    }

    @Override
    public Integer redisHyperLogCount(String key) {
        return redisTemplate.opsForHyperLogLog().size(key).intValue();
    }

    @Override
    public Boolean redisZsetAdd(String key, String value, Integer score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    @Override
    public Integer redisZsetRemove(String key, Object values) {
        return redisTemplate.opsForZSet().remove(key,values).intValue();
    }
/*
备用方法
    @Override
    public LinkedHashMap<Integer, Integer> zsetRevRange(String key, Integer number) {

        //List<Map<Integer, Integer>> list = new ArrayList<>();

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        //Tuple:元组
        Set<ZSetOperations.TypedTuple<String>> tset = redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, number);

        for (ZSetOperations.TypedTuple<String> tuple : tset) {
            Integer aid = Integer.parseInt(tuple.getValue());
            Integer num = tuple.getScore().intValue();

            map.put(aid, num);
        }

        return map;
    }*/

}
