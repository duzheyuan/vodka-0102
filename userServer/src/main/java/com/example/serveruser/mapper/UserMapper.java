package com.example.serveruser.mapper;

import com.example.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/9/26
 * Time: 13:05
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Mapper
public interface UserMapper {
    List<User> selectAllUsers();

    Integer insertNewUser(User user);

    User selectUserByUname(String uname);

    Integer deleteUserByUid(Integer uid);

    User selectUserByUid(Integer uid);

    Integer updatePwd(@Param("uPwd") String uPwd, @Param("uid") Integer uid);

    User selectUserByUUID(String useruuid);
}
