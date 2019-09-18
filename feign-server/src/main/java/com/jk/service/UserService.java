package com.jk.service;

import com.jk.model.LoginUser;

import com.jk.model.Tree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
}
