package com.example.serveruser.service;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import com.example.serveruser.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:05
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class PermissionServiceImpl implements  PermissionService{
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getAllPermission() {
        return permissionMapper.selectAllPermission();
    }

    @Override
    public List<Integer> getAllPowerIDsByPermissionID(Integer permissionID) {
        return permissionMapper.selectAllPowerIDsByPermissionID(permissionID);
    }

    @Override
    public List<Power> getAllPowersByPowerIDs(List<Integer> powerIDs) {
        return permissionMapper.selectAllPowersByPowerIDs(powerIDs);
    }
}
