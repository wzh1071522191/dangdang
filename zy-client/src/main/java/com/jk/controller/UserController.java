package com.jk.controller;

import com.jk.model.Comments;
import com.jk.model.LoginUser;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.service.UserService;

import com.jk.util.Param;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 20:37
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("loginUser")
    @ResponseBody
    public LoginUser loginUser(String username){
        LoginUser user=userService.loginUser(username);
        return user;
     }
   @RequestMapping("tree")
   @ResponseBody
    public List<Tree> tree(Integer userid){
       System.out.println(userid+"555555555");
        return  userService.tree(userid);

   }
   @RequestMapping("ChildNode")
    @ResponseBody
    public List<Tree> treenode(Integer id){
        return userService.treenode(id);
   }

   @RequestMapping("comments")
    @ResponseBody
    public Map comments(@RequestBody Param param){
        return  userService.comments(param);
   }
 @RequestMapping("add")
 @ResponseBody
 public void add(String content){
     System.out.println(content+"asda");
 Comments c=new Comments();

      c.setContent(content);
     c.setDtime(new Date());
     c.setUserid(1);
     userService.add(c);
 }
 @RequestMapping("pinglun")
    @ResponseBody
    public List<Comments> pinglun(){
        return userService.pinglun();
 }
    @RequestMapping("pinglun1")
    @ResponseBody
    public List<Comments> pinglun1(){
        return userService.pinglun1();
    }
    @RequestMapping("audit")
    @ResponseBody
    public  Map audit(@RequestBody Param param){
        return  userService.audit(param);
    }
    //同意按钮实现
    @RequestMapping("tongyi")
    @ResponseBody
    public void tongyi(Integer id){
        System.out.println(id);
        userService.tongyi(id);
    }
    //拒绝按钮实现
    @RequestMapping("jujue")
    @ResponseBody
    public void jujue(Integer id){
        userService.jujue(id);
    }
    //角色查询
    @RequestMapping("role")
    @ResponseBody
    public Map role(@RequestBody Param param){
        return userService.role(param);
    }
    @RequestMapping("setRole")
    @ResponseBody
    public  List<Role> setRole(Integer id){
        List<Role> list=userService.setDep(id);
        return list;
    }
    @RequestMapping("updateRole")
    @ResponseBody
    public void updateRole(Integer uid,Integer rid) {

        userService.updatero(uid,rid);
    }
    //角色查询
    @RequestMapping("Jurisdiction")
    @ResponseBody
    public Map Jurisdiction(@RequestBody Param param){
        return userService.Jurisdiction(param);
    }
    @RequestMapping("queryMenuByRid")
    @ResponseBody
    public List<Tree> queryMenuByRid(Integer id){


        Integer pid=0;

        List<Tree> list = userService.queryMenuByRid(id,pid);



        return list;
    }
    //绑定权限
    @RequestMapping("updateMenu")
    @ResponseBody
    public void updateMenu(Integer[] ids,Integer roleid){
        userService.updateMenu(ids,roleid);
        Integer pid=0;
        Integer id=roleid;
        List<Tree> list= userService.queryMenuByRid(id,pid);


    }
}
