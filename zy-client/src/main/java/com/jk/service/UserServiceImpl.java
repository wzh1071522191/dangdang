package com.jk.service;

import com.jk.dao.UserDao;

import com.jk.model.LoginUser;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.List;

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
    System.out.println(username+"111111111111111111111");
    return userDao.loginUser(username);
  }

  @Override
  public List<Tree> tree(Integer userid) {
    return  userDao.tree(userid);
  }
}
