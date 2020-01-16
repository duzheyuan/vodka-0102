package com.example.clientuser.service;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:16
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface PermissionService {
    List<Permission> getAllPermission();

    List<Integer> getAllPowerIDsByPermissionID(Integer permissionID);

    List<Power> getAllPowersByPowerIDs(List<Integer> powerIDs);

    Map<String, Collection<ConfigAttribute>> getPermissionMap();
}
