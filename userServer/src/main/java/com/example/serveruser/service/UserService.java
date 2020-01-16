package com.example.serveruser.service;

import com.example.common.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/9/26
 * Time: 13:12
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface UserService {
    List<User> getAllUsers();

    Integer addNewUser(User user);

    User getUserByUname(String uname);

    Integer moveUserByUid(Integer uid);

    User getUserByUid(Integer uid);

    Integer updatePwd(String uPwd, Integer uid);
}
