package com.jk.service;

import com.jk.dao.UserDao;

import com.jk.model.Comments;
import com.jk.model.LoginUser;
import com.jk.model.Tree;
import com.jk.util.Param;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  @Override
  public List<Tree> treenode(Integer id) {
    return userDao.treenode(id);
  }

  @Override
  public Map comments(Param param) {
    Integer count=userDao.zong(param);
    Integer page=(param.getPageNumber()-1)*param.getPageSize();
    List<Comments> list =userDao.cha(page,param.getPageSize());
    Map map=new HashMap();
    map.put("total",count);
      map.put("rows",list);

    return map;
  }

  @Override
  public void add(Comments c) {
    System.err.print(c.getContent());
    userDao.add(c);
  }

  @Override
  public List<Comments> pinglun() {
    return userDao.pinglun();
  }
}
