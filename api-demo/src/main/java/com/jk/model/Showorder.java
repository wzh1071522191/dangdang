package com.jk.model;

import lombok.Data;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-20 00:31
 * @description：
 * @package ：com.jk.model
 * @version:
 */
@Data
public class Showorder {
private String ordernumber;
private List<Book> bookList;
private MyOrder myorder;
}

