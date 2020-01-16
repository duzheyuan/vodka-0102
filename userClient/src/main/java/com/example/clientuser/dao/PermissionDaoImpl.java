package com.example.clientuser.dao;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:15
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Component
public class PermissionDaoImpl implements  PermissionDao {
    @Override
    public List<Permission> getAllPermission() {
        System.out.println("PermissionDaoImpl.getAllPermission 返回是null");
        return null;
    }

    @Override
    public List<Integer> getAllPowerIDsByPermissionID(@RequestParam("permissionID") Integer permissionID) {
        System.out.println("PermissionDaoImpl.getAllPowerIDsByPermissionID 返回是null");
        return null;
    }

    @Override
    public List<Power> getAllPowersByPowerIDs(@RequestParam("powerIDs") List<Integer> powerIDs) {
        System.out.println("PermissionDaoImpl.getAllPowersByPowerIDs 返回是null");
        return null;
    }
}
