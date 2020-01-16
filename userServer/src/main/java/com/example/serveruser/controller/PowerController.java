package com.example.serveruser.controller;

import com.example.common.entity.Power;
import com.example.serveruser.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/12
 * Time: 10:37
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
@RestController
public class PowerController {
    @Autowired
    private PowerService powerService;


    /*@GetMapping("power/${powerID}")
    public Power getOneByPowerID(@PathVariable("powerID") Integer powerID) {
        return powerService.getOneByPowerID(powerID);
    }

    @PutMapping("power/${powerID}")
    public Integer setOneStatusByPowerID(@PathVariable("powerID") Integer powerID) {
        return powerService.setOneStatusByPowerID(powerID);
    }

    @PutMapping("power/${powerName}")
    public Integer setOnePowerNameByPowerID(@PathVariable("powerName") String powerName) {
        return powerService.setOnePowerNameByPowerID(powerName);
    }
*/

    @GetMapping("power/get/powerID")
    public Power getOneByPowerID(@RequestParam("powerID") Integer powerID){
        return powerService.getOneByPowerID(powerID);
    }

    @PutMapping("power/put/powerID")
    public Integer setOneStatusByPowerID(@RequestParam("powerID") Integer powerID){
        return powerService.setOneStatusByPowerID(powerID);
    }

    @PutMapping("power/put/powerName")
    public Integer setOnePowerNameByPowerID(@RequestParam("powerName") String powerName){
        return powerService.setOnePowerNameByPowerID(powerName);
    }
}
