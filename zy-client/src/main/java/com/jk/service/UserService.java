package com.jk.service;

import com.jk.model.Comments;
import com.jk.model.LoginUser;
import com.jk.model.Tree;
import com.jk.util.Param;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;


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

    List<Tree> treenode(Integer id);

    Map comments(Param param);

    void add(Comments c);

    List<Comments> pinglun();
}
