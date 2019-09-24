package com.jk.controller;


import com.jk.model.*;
import com.jk.service.UserService;

import com.jk.util.Param;
import com.jk.util.ParameUtil;
import com.jk.util.TreeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.internal.operators.OnSubscribeDelaySubscriptionOther;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 19:37
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String a(){
        return "login";
    }
    @RequestMapping("LoginUser")
    public String login(HttpServletRequest request){

        //验证当前异常是什么异常
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        System.out.println(exceptionClassName+"222222222222");
            if(UnknownAccountException.class.getName().equals(exceptionClassName)|| AuthenticationException.class.getName().equals(exceptionClassName)){
                request.getSession().setAttribute("message","当前用户名不存在");
            }else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                request.getSession().setAttribute("message","密码错误");
        }
      return "login";
    }
  @RequestMapping("index")
    public String index(){
        return "index";
  }
  @RequestMapping("403")
    public String cuo(){
         return "403";
    }
    @RequestMapping("tree")

    public String tree(HttpServletRequest request){
        LoginUser login = (LoginUser) SecurityUtils.getSubject().getSession().getAttribute("login");
        List<Tree> tree=userService.tree(login.getUserid());
        request.getSession().setAttribute("tree",tree);
 return "index";
    }
  @RequestMapping("ChildNode")
   @ResponseBody
    public List<Tree> ChildNode(Integer id,HttpServletRequest request){
        List<Tree> treenode=userService.treenode(id);
       request.getSession().setAttribute("treenode",treenode);
 return treenode;
  }
  @RequestMapping("comments1")
    public String comments(){
        return "pinglun";
  }
  @RequestMapping("comments")
  @ResponseBody
    public Map comments(@RequestBody Param param){

        return  userService.comments(param);
  }
    @RequestMapping("tiaozhuan")
    public  String aa(){
        return "comments";
    }
    @RequestMapping("add")
    @ResponseBody
    public void add(String content){

       userService.add(content);
    }
    @RequestMapping("pinglun")
    public String pinglun(Model model){
        List<Comments> list=userService.pinglun();
        model.addAttribute("list",list);
        return "comments";
    }
<<<<<<< HEAD
=======
    //index.html页面的退出登陆方法
    @RequestMapping("logout")
    public String logout(HttpSession session, Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    //商品的审核页面的跳转   audit：审核
    @RequestMapping("audit1")
    public String audit1(){
  return "audit";
    }

    //商品audit.html跳转的方法进行查询商品审核信息
    @RequestMapping("audit")
    @ResponseBody
    public  Map audit(@RequestBody Param param ){
        return  userService.audit(param);

    }
  //同意按钮实现
    @RequestMapping("tongyi")
    @ResponseBody
    public void tongyi(Integer id){
      userService.tongyi(id);
    }
    //拒绝按钮实现
    @RequestMapping("jujue")
    @ResponseBody
    public void jujue(Integer id){
        userService.jujue(id);
}
//用户查询跳转的页面
    @RequestMapping("role1")
    public  String role1(){
        return "Role";
    }

    //用户查询
    @RequestMapping("role")
    @ResponseBody
    public Map role(@RequestBody Param param){
        return userService.role(param);
    }
   @RequestMapping("setRole")
    public  String setRole(Integer id,Model model){
        List<Role> list=userService.setDep(id);
       model.addAttribute("id",id);
       model.addAttribute("list",list);
       return "updateRole";
   }
    @RequestMapping("updateRole")
    @ResponseBody
    public void updateRole(Integer uid,Integer rid) {

        userService.updatero(uid,rid);
    }
    //角色查询跳转页面
    @RequestMapping("Jurisdiction1")
    public String Jurisdiction1 (){
        return "Jurisdiction";
    }
   @RequestMapping("Jurisdiction")
    @ResponseBody
    public Map Jurisdiction(@RequestBody Param param){
        return userService.Jurisdiction(param);
   }
    @RequestMapping("toUpdateMenu")
    public String toUpdateMenu(Integer id ,Model model){
        model.addAttribute("id",id);
        return "updateMenu";
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
    //查树跳转的页面
    @RequestMapping("chashu")
    public String chashu1(){
        return "Bootstrap";
    }
//查树
    @RequestMapping("chatree")
    @ResponseBody
    public List<Tree> chashu(){
        LoginUser login = (LoginUser) SecurityUtils.getSubject().getSession().getAttribute("login");

       List<Tree> list=userService.chashu(login.getUserid());

      //list = TreeUtil.getFatherNode(list);

       return list;
    }
>>>>>>> origin/master
}
