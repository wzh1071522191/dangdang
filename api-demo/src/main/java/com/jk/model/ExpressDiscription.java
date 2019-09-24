package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:46
 * @description：
 * @package ：com.jk.model
 * @version:
 */
@Data
public class ExpressDiscription {
    private String id;
    private Integer status;
    private  String comment;
    private String personname;
    private String personnumber;
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date expressdate;

}

