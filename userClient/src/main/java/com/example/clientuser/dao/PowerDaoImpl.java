package com.example.clientuser.dao;

import com.example.common.entity.Power;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 11:13
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Component
public class PowerDaoImpl implements PowerDao {

    @Override
    public Power getOneByPowerID(Integer powerID) {
        System.out.println("调用了PowerDao熔断函数A!");
        return null;
    }

    @Override
    public Integer setOneStatusByPowerID(Integer powerID) {
        System.out.println("调用了PowerDao熔断函数B!");
        return null;
    }

    @Override
    public Integer setOnePowerNameByPowerID(String powerName) {
        System.out.println("调用了PowerDao熔断函数C!");
        return null;
    }
}
