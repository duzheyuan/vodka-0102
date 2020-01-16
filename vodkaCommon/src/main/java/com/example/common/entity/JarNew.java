package com.example.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/10
 * Time: 17:06
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public class JarNew {
    private Integer jnID;
    private String jarName;
    private String jarPath_new;
    private Integer jarDowloadNumber;
    private String jarVersion;
    private Double jarSize;
    private Integer uid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date jarUploadTime;
    private String uname;
    private String uuid;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 保留字段
     */
    private String jarSkillOrientation;
    private String jarIntroduce;

    public Integer getJnID() {
        return jnID;
    }

    public void setJnID(Integer jnID) {
        this.jnID = jnID;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    public String getJarPath_new() {
        return jarPath_new;
    }

    public void setJarPath_new(String jarPath_new) {
        this.jarPath_new = jarPath_new;
    }

    public Integer getJarDowloadNumber() {
        return jarDowloadNumber;
    }

    public void setJarDowloadNumber(Integer jarDowloadNumber) {
        this.jarDowloadNumber = jarDowloadNumber;
    }

    public String getJarVersion() {
        return jarVersion;
    }

    public void setJarVersion(String jarVersion) {
        this.jarVersion = jarVersion;
    }

    public Double getJarSize() {
        return jarSize;
    }

    public void setJarSize(Double jarSize) {
        this.jarSize = jarSize;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getJarUploadTime() {
        return jarUploadTime;
    }

    public void setJarUploadTime(Date jarUploadTime) {
        this.jarUploadTime = jarUploadTime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getJarSkillOrientation() {
        return jarSkillOrientation;
    }

    public void setJarSkillOrientation(String jarSkillOrientation) {
        this.jarSkillOrientation = jarSkillOrientation;
    }

    public String getJarIntroduce() {
        return jarIntroduce;
    }

    public void setJarIntroduce(String jarIntroduce) {
        this.jarIntroduce = jarIntroduce;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
