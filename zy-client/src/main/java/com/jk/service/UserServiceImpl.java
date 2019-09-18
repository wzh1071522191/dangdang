package com.jk.service;

import com.jk.dao.UserDao;

import com.jk.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 20:56
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@Service
public class UserServiceImpl implements UserService{
  @Autowired
    private UserDao userDao;
    @Override
    public LoginUser loginUser(String username) {

        return userDao.loginUser(username);
    }
}
