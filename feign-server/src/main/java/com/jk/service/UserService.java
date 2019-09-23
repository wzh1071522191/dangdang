package com.jk.service;

import com.jk.model.Comments;
import com.jk.model.LoginUser;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.util.Param;
import com.jk.util.ParameUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 19:38
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@FeignClient(value = "server-zy")
public interface UserService {
    @RequestMapping("loginUser")
    LoginUser loginUser(@RequestParam String username);
    @RequestMapping("tree")
    List<Tree> tree(@RequestParam Integer userid);
    @RequestMapping("ChildNode")
    List<Tree> treenode(@RequestParam Integer id);
    @RequestMapping("comments")
    Map comments(@RequestBody Param param);
     @RequestMapping("add")
    void add(@RequestParam String content);
     @RequestMapping("pinglun1")
     List<Comments> pinglun();
    @RequestMapping("audit")
    Map audit(@RequestBody Param param);
    @RequestMapping("tongyi")
    void tongyi(@RequestParam Integer id);
    @RequestMapping("jujue")
    void jujue(@RequestParam Integer id);
    @RequestMapping("role")
    Map role(@RequestBody Param param);
    @RequestMapping("setRole")
    List<Role> setDep(@RequestParam Integer id);
    @RequestMapping("updateRole")
    void updatero(@RequestParam Integer uid, @RequestParam Integer rid);
    @RequestMapping("Jurisdiction")
    Map Jurisdiction(@RequestBody Param param);
    @RequestMapping("queryMenuByRid")
    List<Tree> queryMenuByRid(@RequestParam Integer id, @RequestParam Integer pid);
    @RequestMapping("updateMenu")
    void updateMenu(@RequestParam Integer[] ids, @RequestParam Integer roleid);
}
