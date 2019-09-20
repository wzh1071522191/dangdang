package com.jk.util;

import java.io.Serializable;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/19 19:24
 * @description：
 * @package ：com.jk.util
 * @version:
 */
public class Param implements Serializable {
    private Integer pageNumber;
    private Integer pageSize;

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
}
