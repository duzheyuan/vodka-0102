package com.example.clientuser.dao;

import com.example.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/9
 * Time: 10:18
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
@FeignClient(value = "user-server", fallback = UserDaoImpl.class)
public interface UserDao {
    @GetMapping("users/{uname}")
    User LoginCheck(@PathVariable("uname") String uname);

    @GetMapping("users")
    List<User> getAllUsers();


    @PostMapping("users")
    Integer registerUser(@RequestBody User user);

    @DeleteMapping("users/{uid}")
    Integer deleteUserByUid(@PathVariable("uid") Integer uid);

    @GetMapping("users/uid")
    User getUserByUid(@RequestParam("uid") Integer uid);

    @PostMapping("user/update/pwd")
    Integer updatePwd(@RequestParam("uPwd") String uPwd, @RequestParam("uid") Integer uid);
}
