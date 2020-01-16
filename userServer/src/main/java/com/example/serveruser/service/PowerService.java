package com.example.serveruser.service;

import com.example.common.entity.Power;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 10:28
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public interface PowerService {
    Power getOneByPowerID(Integer powerID);
    Integer setOneStatusByPowerID(Integer powerID);
    Integer setOnePowerNameByPowerID(String powerName);
}
