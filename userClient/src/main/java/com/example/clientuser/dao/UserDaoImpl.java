package com.example.clientuser.dao;

import com.example.common.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/9
 * Time: 10:22
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public User LoginCheck(String uname) {
        System.out.println("该用户不存在，详细参加！Hystrix UserDao");
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("调用了hystrix!!");
        return null;
    }

    @Override
    public Integer registerUser(User user) {
        System.out.println("调用了hystrix!!");
        return 0;
    }

    @Override
    public Integer deleteUserByUid(Integer uid) {
        System.out.println("调用了hystrix!!");
        return 0;
    }

    @Override
    public User getUserByUid(Integer uid) {
        return null;
    }

    @Override
    public Integer updatePwd(String uPwd, Integer uid) {
        return null;
    }
}
