package com.jk.dao;


import com.jk.model.Books;
import com.jk.model.Comments;
import com.jk.model.LoginUser;
import com.jk.model.Tree;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 20:50
 * @description：
 * @package ：com.jk.dao
 * @version:
 */
public interface UserDao {

    LoginUser loginUser(@Param("username") String username);

    List<Tree> tree(@Param("id") Integer userid);

    List<Tree> treenode(@Param("id") Integer id);

    Integer zong(com.jk.util.Param param);

    List<Comments> cha(@Param("page") Integer page,@Param("rows") Integer pageSize);

    void add(Comments c);

    List<Comments> pinglun();

    List<Comments> pinglun1();

    Integer azong(com.jk.util.Param param);

    List<Books> acha(@Param("page") Integer page, @Param("rows") Integer pageSize);

    void tongyi(@Param("id") Integer id);

    void jujue(@Param("id")Integer id);
}
