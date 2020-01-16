package com.example.serveruser.service;

import com.example.common.entity.Power;
import com.example.serveruser.mapper.PowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 10:28
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;
    @Override
    public Power getOneByPowerID(Integer powerID) {
        return powerMapper.selectOneByPowerID(powerID);
    }

    @Override
    public Integer setOneStatusByPowerID(Integer powerID) {
        return powerMapper.updateOneStatusByPowerID(powerID);
    }

    @Override
    public Integer setOnePowerNameByPowerID(String powerName) {
        return powerMapper.updateOnePowerNameByPowerID(powerName);
    }
}
