package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.scene.chart.PieChart;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class LunBo implements Serializable {
    private Integer lbid;  //轮播图id
    private Integer paixu;  //排序
    private Integer type;//类型
    private String img; //图片
    private Integer maxlength;  //长
    private Integer minlength;   //宽
    private String address;    //链接路径
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前
    private Date addtime; //上传时间
    private Integer status;  //状态  默认是关闭状态   2

    public Integer getLbid() {
        return lbid;
    }

    public void setLbid(Integer lbid) {
        this.lbid = lbid;
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(Integer maxlength) {
        this.maxlength = maxlength;
    }

    public Integer getMinlength() {
        return minlength;
    }

    public void setMinlength(Integer minlength) {
        this.minlength = minlength;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
