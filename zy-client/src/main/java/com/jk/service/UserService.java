package com.jk.service;

import com.jk.model.LoginUser;
import com.jk.model.Tree;

import java.util.List;


/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 20:55
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface UserService {

    LoginUser loginUser(String username);

    List<Tree> tree(Integer userid);
}
