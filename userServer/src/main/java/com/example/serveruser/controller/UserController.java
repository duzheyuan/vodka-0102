package com.example.serveruser.controller;

import com.example.common.entity.User;
import com.example.serveruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/9/26
 * Time: 13:13
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users/{uname}")
    public User LoginCheck(@PathVariable("uname") String uname) {
        return userService.getUserByUname(uname);
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("users")
    public Integer registerUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @DeleteMapping("users/{uid}")
    public Integer deleteUserByUid(@PathVariable("uid") Integer uid) {
        return userService.moveUserByUid(uid);
    }

    @GetMapping("users/uid")
    public User getUserByUid(@RequestParam("uid") Integer uid) {
        return userService.getUserByUid(uid);
    }

    @PostMapping("user/update/pwd")
    public Integer updatePwd(@RequestParam("uPwd") String uPwd, @RequestParam("uid") Integer uid) {
        return userService.updatePwd(uPwd, uid);
    }
}
