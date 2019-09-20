package com.jk.util;

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
public class ParameUtil implements Serializable {
    private static final long serialVersionUID = 6745998963246803351L;

    private Integer pageNumber;
    private Integer pageSize;
    private String sortName;      //排序字段
    private String sortOrder;
    private Integer carbrandid;
    private String typename;
    private String carareaid;

}
