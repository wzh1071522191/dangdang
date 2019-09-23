package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-20 17:11
 * @description：
 * @package ：com.jk.model
 * @version:
 */
@Data
public class UserGwd implements Serializable {
private String userid;
private List<Gwd> gwdList;
}

