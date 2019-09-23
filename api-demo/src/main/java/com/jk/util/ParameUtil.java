package com.jk.util;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
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


}