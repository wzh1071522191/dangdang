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
    private String  orderallid;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getBookcount() {
        return bookcount;
    }

    public void setBookcount(Integer bookcount) {
        this.bookcount = bookcount;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String  getOrderallid() {
        return orderallid;
    }

    public void setOrderallid(String  orderallid) {
        this.orderallid = orderallid;
    }
}

