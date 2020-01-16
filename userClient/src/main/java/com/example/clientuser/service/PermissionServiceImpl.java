package com.example.clientuser.service;

import com.example.clientuser.dao.PermissionDao;
import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:16
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class PermissionServiceImpl implements  PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    private Map<String, Collection<ConfigAttribute>> permissionMap=null;
    @Override
    public List<Permission> getAllPermission() {
        return permissionDao.getAllPermission();
    }

    @Override
    public List<Integer> getAllPowerIDsByPermissionID(Integer permissionID) {
        return permissionDao.getAllPowerIDsByPermissionID(permissionID);
    }

    @Override
    public List<Power> getAllPowersByPowerIDs(List<Integer> powerIDs) {
        return permissionDao.getAllPowersByPowerIDs(powerIDs);
    }

    /**
     * 从数据库中获得所有的权限信息
     */
    public  void initPermission(){
        System.out.println("执行到 initPermission：从数据库中获得所有的权限信息！！！");
        permissionMap=new HashMap<>();
        List<Permission> permissions=permissionDao.getAllPermission();
        for (Permission permission : permissions) {
            List<Integer> powerIDs=permissionDao.getAllPowerIDsByPermissionID(permission.getPermissionID());
            permission.setPowers(permissionDao.getAllPowersByPowerIDs(powerIDs));
            Collection<ConfigAttribute> configAttributes=new ArrayList<>();
            for (Power power : permission.getPowers()) {
                ConfigAttribute configAttribute=new SecurityConfig("ROLE_"+power.getPowerName());
                configAttributes.add(configAttribute);
            }
            permissionMap.put(permission.getUrl(),configAttributes);
        }
        System.out.println("initPermission():"+permissionMap);
    }

    @Override
    public  Map<String, Collection<ConfigAttribute>> getPermissionMap(){
        System.out.println("开始从数据库加载权限信息！！getPermissionMap");
        if( permissionMap==null || permissionMap.size()==0) {
            initPermission();
        }
        System.out.println("getPermissionMap()："+permissionMap);
        return permissionMap;
    }
}
