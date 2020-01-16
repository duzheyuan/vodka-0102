package com.example.redisserver.service;

import com.example.redisserver.dao.RedisUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/11
 * Time: 16:25
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class RedisUserServiceImpl  implements  RedisUserService{
    @Autowired
    private RedisUserDao redisUserDao;
    @Override
    public void redisSet(String key, String value) {
        redisUserDao.redisSet(key,value);
    }

    @Override
    public String redisGet(String key) {
        return redisUserDao.redisGet(key);
    }

    @Override
    public Boolean redisDelete(String key) {
        return redisUserDao.redisDelete(key);
    }

    @Override
    public Integer redisDeleteKeys(List<String> keys) {
        return redisUserDao.redisDeleteKeys(keys);
    }

    @Override
    public Boolean redisHasKey(String key) {
        return redisUserDao.redisHasKey(key);
    }

    @Override
    public Boolean redisExpire(String key, Integer timeout) {
        return redisUserDao.redisExpire(key,timeout);
    }

    @Override
    public Boolean redisPersist(String key) {
        return redisUserDao.redisPersist(key);
    }

    @Override
    public Integer redisHyperLogAdd(String key, String value) {
        return redisUserDao.redisHyperLogAdd(key,value);
    }

    @Override
    public Integer redisHyperLogCount(String key) {
        return redisUserDao.redisHyperLogCount(key);
    }

    @Override
    public Boolean redisZsetAdd(String key, String value, Integer score) {
        return redisUserDao.redisZsetAdd(key,value,score);
    }

    @Override
    public Integer redisZsetRemove(String key, Object values) {
        return redisUserDao.redisZsetRemove(key,values);
    }
}
