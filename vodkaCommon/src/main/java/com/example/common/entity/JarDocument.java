package com.example.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/10
 * Time: 17:04
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
//对表
@Document(collection = "jarDocument")
public class JarDocument {
    //对字段
    @Field("jdID")
    private Integer jdID;
    @Field("joID")
    private Integer joID;
    @Field("jdUploadTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date jdUploadTime;
    /*
     *@DatetimeFormat是将String转换成Date，一般前台给后台传值时用
     *JsonFormat(pattern=”yyyy-MM-dd”) 将Date转换成String 一般后台传值给前台时
     * */
    //存储文本----暂时使用string类型
    @Field("document")
    private String document;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Field("uuid")
    private String uuid;

    //保留字段
    @Field("jdPath")
    private String jdPath;


    @Field("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getJdUploadTime() {
        return jdUploadTime;
    }

    public void setJdUploadTime(Date jdUploadTime) {
        this.jdUploadTime = jdUploadTime;
    }


    public Integer getJdID() {
        return jdID;
    }

    public void setJdID(Integer jdID) {
        this.jdID = jdID;
    }

    public Integer getJoID() {
        return joID;
    }

    public void setJoID(Integer joID) {
        this.joID = joID;
    }

    public String getJdPath() {
        return jdPath;
    }

    public void setJdPath(String jdPath) {
        this.jdPath = jdPath;
    }
}
