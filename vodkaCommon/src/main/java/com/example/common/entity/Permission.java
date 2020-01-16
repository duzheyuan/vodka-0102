package com.example.common.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/11/17
 * Time: 16:30
 * Description: No Description
 *
 * @author:ZhouRunLin
 */
public class Permission {
    private Integer permissionID;
    private String powerName;
    private String description;
    /**
     *  注意：Permission 表的url通配符为两颗星，比如说 /user下的所有url，应该写成 /user/**;
     */
    private String url;
    private List<Power> powers;
    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }



    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
