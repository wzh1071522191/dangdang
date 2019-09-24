package com.jk.model;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.List;

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
    private JSON state ;

    //private String status;

    private String checked;

    public JSON getState() {
        return state;
    }

    public void setState(JSON state) {
        this.state = state;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public List<Tree> getNodes() {
        return nodes;
    }

    public void setNodes(List<Tree> nodes) {
        this.nodes = nodes;
    }

    private List<Tree> nodes;

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
