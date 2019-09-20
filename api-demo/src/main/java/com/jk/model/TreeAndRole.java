package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/18 21:40
 * @description：
 * @package ：com.jk.model
 * @version:
 */
public class TreeAndRole implements Serializable {
    private Integer id;
    private Integer roleid;
    private Integer treeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getTreeid() {
        return treeid;
    }

    public void setTreeid(Integer treeid) {
        this.treeid = treeid;
    }
}
