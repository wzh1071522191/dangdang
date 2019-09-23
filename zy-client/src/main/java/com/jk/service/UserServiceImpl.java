package com.jk.service;


import com.jk.dao.UserDao;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.*;
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
    System.err.print(c.getContent()+"444");
    userDao.add(c);
  }

  @Override
  public List<Comments> pinglun() {

    return  userDao.pinglun();
  }

  @Override
  public List<Comments> pinglun1() {
    return userDao.pinglun1();
  }

  @Override
  public Map audit(Param param) {
    Integer  count= userDao.azong(param);
    Integer page=(param.getPageNumber()-1)*param.getPageSize();
    List<Books> list=userDao.acha(page,param.getPageSize());
    Map ma=new HashMap();
    ma.put("total",count);
    ma.put("rows",list);
    return ma;
  }

  @Override
  public void tongyi(Integer id) {
    userDao.tongyi(id);
  }

  @Override
  public void jujue(Integer id) {
    userDao.jujue(id);
  }

  @Override
  public Map role(Param param) {
    Integer count= userDao.rzong(param);
    Integer page=(param.getPageNumber()-1)*param.getPageSize();
    List<LoginUser> list=userDao.rcha(page,param.getPageSize());
    Map ma=new HashMap();
    ma.put("total",count);
    ma.put("rows",list);
    return ma;
  }

  @Override
  public List<Role> setDep(Integer id) {
    List<Integer> queryId=userDao.queryRoleById(id);
    List<Role> queryAllRole=userDao.queryAllRole();
    for (int i = 0; i < queryId.size(); i++) {
      for (int j = 0; j < queryAllRole.size(); j++) {
        if (queryAllRole.get(j).getId()==queryId.get(i)) {
          queryAllRole.get(j).setChecked("true");
        }
      }
    }
    return queryAllRole;
  }

  @Override
  public void updatero(Integer uid, Integer rid) {
    userDao.deleteRole(uid);

    userDao.updateRole(uid,rid);
  }

  @Override
  public Map Jurisdiction(Param param) {
      Integer count=userDao.jzong();
      Integer page=(param.getPageNumber()-1)*param.getPageSize();
      List<Role> list=userDao.jcha(page,param.getPageSize());
      Map ma=new HashMap();
      ma.put("total",count);
      ma.put("rows",list);

    return ma;
  }

  @Override
  public List<Tree> queryMenuByRid(Integer id, Integer pid) {
    JSONObject json = new JSONObject();
    List<Tree> list = queryOrgAll3(pid);
    List<Tree> list2 = queryOrgAll2(id, pid);
    Map map = new HashMap();
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list2.size(); j++) {
        if (list.get(i).getId() == list2.get(j).getId()) {
          list.get(i).getId();
          json.put("checked", true);
          list.get(i).setState(json);
        }
      }
      if (list.size() > 0) {
        for (int s = 0; s < list.size(); s++) {
          List<Tree> list3 = queryMenuByRid(id, list.get(s).getId());
          list.get(s).setNodes(list3);
        }
      }
    }
    return list;
  }

  public List<Tree> queryOrgAll3(Integer pid) {
    // 根据pid查询子节点
    List<Tree> menu = userDao.queryMenuAll(pid);
    // 如果查询到子节点集合
    if(menu != null && menu.size()>0){
      // 循环集合，将每个机构对象的id作为pid 继续查询子节点集合
      for (int i = 0; i < menu.size(); i++) {
        List<Tree> orgs2 = queryOrgAll3(menu.get(i).getId());
        // 将查询的子节点集合放到该结构对象的children属性中
        menu.get(i).setNodes(orgs2);
      }
    }
    return menu;
  }

  public List<Tree> queryOrgAll2(Integer id, Integer pid) {
    // 根据pid查询子节点
    Map<String,Object> map =new HashMap<String,Object>();

    List<Tree> orgs = userDao.queryMenuAllById(id,pid);
    // 如果查询到子节点集合
    if(orgs != null && orgs.size()>0){
      // 循环集合，将每个机构对象的id作为pid 继续查询子节点集合
      for (int i = 0; i < orgs.size(); i++) {
        List<Tree> orgs2 = queryOrgAll2(id,orgs.get(i).getId());
        // 将查询的子节点集合放到该结构对象的children属性中
        orgs.get(i).setNodes(orgs2);
      }
    }
    return orgs;
  }

  @Override
  public void updateMenu(Integer[] ids, Integer roleid) {
    userDao.deleteRoleMenu(roleid);
    for (int i = 0; i <ids.length ; i++) {
      TreeAndRole rm=new TreeAndRole();
      rm.setTreeid(ids[i]);
      rm.setRoleid(roleid);
      userDao.addRoleMenu(rm);
    }
  }

}
