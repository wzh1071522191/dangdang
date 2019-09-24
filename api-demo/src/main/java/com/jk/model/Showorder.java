package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-20 00:31
 * @description：
 * @package ：com.jk.model
 * @version:
 */
public class Showorder implements Serializable {
private String ordernumber;
private List<Book> bookList;
private MyOrder myorder;

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public MyOrder getMyorder() {
        return myorder;
    }

    public void setMyorder(MyOrder myorder) {
        this.myorder = myorder;
    }

    @Override
    public String toString() {
        return "Showorder{" +
                "ordernumber='" + ordernumber + '\'' +
                ", bookList=" + bookList +
                ", myorder=" + myorder +
                '}';
    }
}

