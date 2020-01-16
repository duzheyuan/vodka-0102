package com.example.serveruser.controller;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import com.example.serveruser.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:07
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("permission/get/AllPermissions")
    public List<Permission> getAllPermission() {
        return permissionService.getAllPermission();
    }

    @GetMapping("permission/get/AllPowerIDsByPermissionID")
    public List<Integer> getAllPowerIDsByPermissionID(@RequestParam("permissionID") Integer permissionID) {
        return permissionService.getAllPowerIDsByPermissionID(permissionID);
    }

    @GetMapping("permission/get/AllPowersByPowerIDs")
    public List<Power> getAllPowersByPowerIDs(@RequestParam("powerIDs") List<Integer> powerIDs) {
        return permissionService.getAllPowersByPowerIDs(powerIDs);
    }

}
