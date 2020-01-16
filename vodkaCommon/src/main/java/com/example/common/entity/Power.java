package com.example.common.entity;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/10
 * Time: 16:59
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public class Power {
    private Integer powerID;
    private String powerName;
    private Integer status;

    public Integer getPowerID() {
        return powerID;
    }

    public void setPowerID(Integer powerID) {
        this.powerID = powerID;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
