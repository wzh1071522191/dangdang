package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/18 21:39
 * @description：
 * @package ：com.jk.model
 * @version:
 */
public class Role implements Serializable {
    private Integer id;
    private Integer roleid;
    private String roleplay;
    private  String checked;

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

    public String getRoleplay() {
        return roleplay;
    }

    public void setRoleplay(String roleplay) {
        this.roleplay = roleplay;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
