package com.example.clientuser.service;

import com.example.clientuser.dao.PowerDao;
import com.example.common.entity.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 10:54
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Service
public class PowerServiceImpl implements  PowerService{

    @Autowired
    private PowerDao powerDao;
    @Override
    public Power getOneByPowerID(Integer powerID) {
        return powerDao.getOneByPowerID(powerID);
    }

    @Override
    public Integer setOneStatusByPowerID(Integer powerID) {
        return powerDao.setOneStatusByPowerID(powerID);
    }

    @Override
    public Integer setOnePowerNameByPowerID(String powerName) {
        return powerDao.setOnePowerNameByPowerID(powerName);
    }
}
