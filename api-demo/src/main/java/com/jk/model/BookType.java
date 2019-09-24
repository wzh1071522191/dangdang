package com.jk.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/18 9:20
 * @Description :   书籍类型表
 * @Package :   com.jk.model
 */
public class BookType implements Serializable {

    private static final long serialVersionUID = -3372182821801717734L;
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

    @Override
    public String toString() {
        return "BookType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", pid=" + pid +
                '}';
    }
}
