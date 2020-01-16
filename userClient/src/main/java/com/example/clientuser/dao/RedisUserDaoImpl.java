package com.example.clientuser.dao;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 11:17
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Component
public class RedisUserDaoImpl implements  RedisUserDao{
    @Override
    public void redisSet(String key, String value) {
        System.out.println("调用了Redis熔断函数的熔断函数A!");
    }

    @Override
    public String redisGet(String key) {
        System.out.println("调用了Redis熔断函数的熔断函数B!");
        return null;
    }

    @Override
    public Boolean redisDelete(String key) {
        System.out.println("调用了Redis熔断函数的熔断函数C!");
        return null;
    }

    @Override
    public Integer redisDeleteKeys(List<String> keys) {
        System.out.println("调用了Redis熔断函数的熔断函数D!");
        return null;
    }

    @Override
    public Boolean redisHasKey(String key) {
        System.out.println("调用了Redis熔断函数的熔断函数E!");
        return null;
    }

    @Override
    public Boolean redisExpire(String key, Integer timeout) {
        System.out.println("调用了Redis熔断函数的熔断函数F!");
        return null;
    }

    @Override
    public Boolean redisPersist(String key) {
        System.out.println("调用了Redis熔断函数的熔断函数G!");
        return null;
    }

    @Override
    public Integer redisHyperLogAdd(String key, String value) {
        System.out.println("调用了Redis熔断函数的熔断函数H!");
        return null;
    }

    @Override
    public Integer redisHyperLogCount(String key) {
        System.out.println("调用了Redis熔断函数的熔断函数L!");
        return null;
    }

    @Override
    public Boolean redisZsetAdd(String key, String value, Integer score) {
        System.out.println("调用了Redis熔断函数的熔断函数M!");
        return null;
    }

    @Override
    public Integer redisZsetRemove(String key, Object values) {
        System.out.println("调用了Redis熔断函数的熔断函数Q!");
        return null;
    }
}
