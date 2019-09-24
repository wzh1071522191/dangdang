package com.jk.util;

<<<<<<< HEAD
import lombok.Data;

import java.io.Serializable;

/**
 * @author ： 张松光
 * @date ：Created in 2019/9/17 17:37
 * @description：分页工具
 * @package ：com.jk.util
 * @version: 1.1.0
 */
@Data
=======

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
>>>>>>> origin/master
public class ParameUtil implements Serializable {
    private static final long serialVersionUID = 6745998963246803351L;

    private Integer pageNumber;
    private Integer pageSize;
    private String sortName;      //排序字段
    private String sortOrder;
    private Integer carbrandid;
    private String typename;
    private String carareaid;
<<<<<<< HEAD
}
=======
    private Integer typeId;
    private Integer typePid;


    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")// 处理从	后端到前端的时间
    private Date starDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")// 处理从	后端到前端的时间
    private Date endDate;
    private String name;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getQian() {
        return qian;
    }

    public void setQian(String qian) {
        this.qian = qian;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFang() {
        return fang;
    }

    public void setFang(Integer fang) {
        this.fang = fang;
    }

    public Integer getZhuang() {
        return zhuang;
    }

    public void setZhuang(Integer zhuang) {
        this.zhuang = zhuang;
    }

    public Integer getKuan() {
        return kuan;
    }

    public void setKuan(Integer kuan) {
        this.kuan = kuan;
    }

    public Integer getRe() {
        return re;
    }

    public void setRe(Integer re) {
        this.re = re;
    }

    public Integer getCarstatus() {
        return carstatus;
    }

    public void setCarstatus(Integer carstatus) {
        this.carstatus = carstatus;
    }

    public Integer getCarbrandid() {
        return carbrandid;
    }

    public void setCarbrandid(Integer carbrandid) {
        this.carbrandid = carbrandid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getCarareaid() {
        return carareaid;
    }

    public void setCarareaid(String carareaid) {
        this.carareaid = carareaid;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ParameUtil{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", sortName='" + sortName + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", qian='" + qian + '\'' +
                ", ho='" + ho + '\'' +
                ", id=" + id +
                ", fang=" + fang +
                ", zhuang=" + zhuang +
                ", kuan=" + kuan +
                ", re=" + re +
                ", carstatus=" + carstatus +
                ", carbrandid=" + carbrandid +
                ", typename='" + typename + '\'' +
                ", carareaid='" + carareaid + '\'' +
                ", typeId=" + typeId +
                ", typePid=" + typePid +
                ", status=" + status +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                '}';
    }
}
>>>>>>> origin/master
