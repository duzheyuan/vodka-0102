package com.example.clientuser.dao;

import com.example.common.entity.Power;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 10:53
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@Repository
@FeignClient(value = "user-server",fallback = PowerDaoImpl.class)
public interface PowerDao {

    /*@GetMapping("power/${powerID}")
    Power getOneByPowerID(@PathVariable("powerID") Integer powerID);

    @PutMapping("power/${powerID}")
    Integer setOneStatusByPowerID(@PathVariable("powerID") Integer powerID);

    @PutMapping("power/${powerName}")
    Integer setOnePowerNameByPowerID(@PathVariable("powerName") String powerName);*/

    @GetMapping("power/get/powerID")
    Power getOneByPowerID(@RequestParam("powerID") Integer powerID);

    @PutMapping("power/put/powerID")
    Integer setOneStatusByPowerID(@RequestParam("powerID")Integer powerID);

    @PutMapping("power/put/powerName")
    Integer setOnePowerNameByPowerID(@RequestParam("powerName")String powerName);
}
