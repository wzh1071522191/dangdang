package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/20 20:07
 * @description：
 * @package ：com.jk.model
 * @version:
 */
public class BookTypes implements Serializable {
    private Integer typeId;

    private String typeName;

    private Integer pid;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
