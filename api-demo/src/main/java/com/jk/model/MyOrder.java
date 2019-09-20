package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 10:29
 * @description：
 * @package ：com.jk.model
 * @version:
 */
@Data
public class MyOrder implements Serializable {
    private Integer orderid;
    private String ordernumber;
    private String bookname;
    private Double orderprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderdate;
    private Integer bookcount;
    private Integer orderstatus;
    private String orderallid;
    private String username;
    private String userphone;
}

