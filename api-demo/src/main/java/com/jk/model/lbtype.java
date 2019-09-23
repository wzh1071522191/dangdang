package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class lbtype implements Serializable {
    private Integer typeid;
    private String typename;
    private String typedesc;
    private Date typetime;
    private Integer typestatus;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc;
    }

    public Date getTypetime() {
        return typetime;
    }

    public void setTypetime(Date typetime) {
        this.typetime = typetime;
    }

    public Integer getTypestatus() {
        return typestatus;
    }

    public void setTypestatus(Integer typestatus) {
        this.typestatus = typestatus;
    }
}
