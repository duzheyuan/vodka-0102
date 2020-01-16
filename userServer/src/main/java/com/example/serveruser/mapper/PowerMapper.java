package com.example.serveruser.mapper;

import com.example.common.entity.Permission;
import com.example.common.entity.Power;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 10:20
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Mapper
public interface PowerMapper {
    Power selectOneByPowerID(Integer powerID);
    Integer updateOneStatusByPowerID(Integer powerID);
    Integer updateOnePowerNameByPowerID(String powerName);
    Integer insertIntoPowerAndUserTable(Integer uid,Integer powerID);

    /**
     * uid_power TABLE
     */
    List<Power> selectAllPowersByPowerIDs(List<Integer> powerIDs);
    List<Integer> selectAllPowerIDsByuid(Integer uid);

}
