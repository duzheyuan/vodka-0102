package com.example.clientuser.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/11
 * Time: 16:25
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface RedisUserService {
    //增加key value
    void redisSet(String key, String value);

    //查询key
    String redisGet(String key);

    //删除key
    Boolean redisDelete(String key);

    //批量删除key
    Integer redisDeleteKeys(List<String> keys);

    //是否存在key
    Boolean redisHasKey(String key);

    //设置key的过期时间
    Boolean redisExpire(String key, Integer timeout);

    //取消过期时间
    Boolean redisPersist(String key);

    //HyperLog记录
    Integer redisHyperLogAdd(String key, String value);

    //获得记录数
    Integer redisHyperLogCount(String key);

    //有序set添加
    Boolean redisZsetAdd(String key, String value, Integer score);

    //移除有序set（单个或批量）
    Integer redisZsetRemove(String key, Object values);

}
