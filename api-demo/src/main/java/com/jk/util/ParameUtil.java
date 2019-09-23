package com.jk.util;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ParameUtil implements Serializable {
    private static final long serialVersionUID = 1486269777590726558L;
    private Integer pageNumber;
    private Integer pageSize;
    private String sortName;      //排序字段
    private String sortOrder;    //正序或倒,+-序
    private String qian;
    private String ho;
    private Integer id;
    private Integer fang;
    private Integer zhuang;
    private Integer kuan;
    private Integer re;
    private Integer carstatus;
    private Integer carbrandid;
    private String typename;
    private String carareaid;
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

    public Integer getStatus() {
        return status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public void setStatus(Integer status) {
        this.status = status;


    }
}