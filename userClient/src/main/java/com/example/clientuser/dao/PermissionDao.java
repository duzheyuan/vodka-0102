package com.example.clientuser.dao;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:13
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
@FeignClient(value = "user-server", fallback = PermissionDaoImpl.class)
public interface PermissionDao {
    @GetMapping("permission/get/AllPermissions")
    List<Permission> getAllPermission();

    @GetMapping("permission/get/AllPowerIDsByPermissionID")
    List<Integer> getAllPowerIDsByPermissionID(@RequestParam("permissionID") Integer permissionID);

    @GetMapping("permission/get/AllPowersByPowerIDs")
    List<Power> getAllPowersByPowerIDs(@RequestParam("powerIDs") List<Integer> powerIDs);
}
