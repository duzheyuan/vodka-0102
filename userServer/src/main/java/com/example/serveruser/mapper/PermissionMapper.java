package com.example.serveruser.mapper;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 17:02
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Mapper
public interface PermissionMapper {
    /**
     * permission_power TABLE
     */
    List<Permission> selectAllPermission();
    List<Integer> selectAllPowerIDsByPermissionID(Integer permissionID);
    List<Power> selectAllPowersByPowerIDs(List<Integer> powerIDs);
}
