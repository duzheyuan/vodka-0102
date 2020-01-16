package com.example.clientuser.service;

import com.example.clientuser.dao.UserDao;
import com.example.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/9
 * Time: 10:29
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Integer addNewUser(User user) {
        return userDao.registerUser(user);
    }

    @Override
    public User getUserByUname(String uname) {
        return userDao.LoginCheck(uname);
    }

    @Override
    public Integer moveUserByUid(Integer uid) {
        return userDao.deleteUserByUid(uid);
    }

    @Override
    public User getUserByUid(Integer uid) {
        return userDao.getUserByUid(uid);
    }

    @Override
    public Integer updatePwd(String uPwd, Integer uid) {
        return userDao.updatePwd(uPwd, uid);
    }
}
