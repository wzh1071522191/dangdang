package com.jk.model;

import lombok.Data;
import org.w3c.dom.Comment;

import java.util.ArrayList;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:45
 * @description：
 * @package ：com.jk.model
 * @version:
 */
@Data
public class Express {
    private String id;
    private String numbers;
    public ArrayList<ExpressDiscription> details =new ArrayList<ExpressDiscription>();
}

