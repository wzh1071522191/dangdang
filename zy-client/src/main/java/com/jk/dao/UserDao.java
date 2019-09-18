package com.jk.dao;


import com.jk.model.LoginUser;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 20:50
 * @description：
 * @package ：com.jk.dao
 * @version:
 */
public interface UserDao {
    LoginUser loginUser(String username);
}
