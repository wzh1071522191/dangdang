package com.jk.dao;


import com.jk.model.*;

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

    Integer rzong(com.jk.util.Param param);

    List<LoginUser> rcha(@Param("page") Integer page, @Param("rows")Integer pageSize);

    List<Integer> queryRoleById(@Param("id") Integer id);

    List<Role> queryAllRole();

    void deleteRole(@Param("uid")Integer uid);

    void updateRole(@Param("uid")Integer uid, @Param("rid")Integer rid);

    Integer jzong();

    List<Role> jcha(@Param("page")Integer page, @Param("rows")Integer pageSize);


    List<Tree> queryMenuAll(@Param("pid")Integer pid);

    List<Tree> queryMenuAllById(@Param("id")Integer id, @Param("pid")Integer pid);

    void deleteRoleMenu(@Param("roleid")Integer roleid);

    void addRoleMenu(TreeAndRole rm);
}
