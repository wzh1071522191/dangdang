package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/18 21:39
 * @description：
 * @package ：com.jk.model
 * @version:
 */
public class Tree implements Serializable {
    private Integer id;
    private String text;
    private Integer pid;
    private String url;
    private String iconclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass;
    }
}
