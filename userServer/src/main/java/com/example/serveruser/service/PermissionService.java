package com.example.serveruser.service;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:05
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface PermissionService {
    List<Permission> getAllPermission();
    List<Integer> getAllPowerIDsByPermissionID(Integer permissionID);
    List<Power> getAllPowersByPowerIDs(List<Integer> powerIDs);
}
