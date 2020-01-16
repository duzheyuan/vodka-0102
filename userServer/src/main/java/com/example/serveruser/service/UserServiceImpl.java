package com.example.serveruser.service;

import com.example.common.entity.Power;
import com.example.common.entity.User;
import com.example.serveruser.mapper.PowerMapper;
import com.example.serveruser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/9/26
 * Time: 13:12
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public Integer addNewUser(User user) {
        //插入权限到uid_power表中
        Integer num = userMapper.insertNewUser(user);
        user = userMapper.selectUserByUUID(user.getUseruuid());
        powerMapper.insertIntoPowerAndUserTable(user.getUid(), 3);
        return num;
    }

    @Override
    public User getUserByUname(String uname) {
        //角色信息进行填充
        User user = userMapper.selectUserByUname(uname);
        /**
         * 装载权限对象
         */
        if(user!=null){
            List<Integer> powerIDs = powerMapper.selectAllPowerIDsByuid(user.getUid());
            List<Power> powers = powerMapper.selectAllPowersByPowerIDs(powerIDs);
            user.setPowers(powers);
        }
        return user;
    }

    @Override
    public Integer moveUserByUid(Integer uid) {
        return userMapper.deleteUserByUid(uid);
    }

    @Override
    public User getUserByUid(Integer uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    public Integer updatePwd(String uPwd, Integer uid) {
        return userMapper.updatePwd(uPwd, uid);
    }
}
