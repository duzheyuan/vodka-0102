package com.example.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/10
 * Time: 17:00
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public class JarUpdate {
    private Integer juID;
    private String juIntroduce;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date juUpdateTime;
    private Integer joID;

    private String uuid;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public Integer getJuID() {
        return juID;
    }

    public void setJuID(Integer juID) {
        this.juID = juID;
    }

    public String getJuIntroduce() {
        return juIntroduce;
    }

    public void setJuIntroduce(String juIntroduce) {
        this.juIntroduce = juIntroduce;
    }

    public Date getJuUpdateTime() {
        return juUpdateTime;
    }

    public void setJuUpdateTime(Date juUpdateTime) {
        this.juUpdateTime = juUpdateTime;
    }

    public Integer getJoID() {
        return joID;
    }

    public void setJoID(Integer joID) {
        this.joID = joID;
    }

}
