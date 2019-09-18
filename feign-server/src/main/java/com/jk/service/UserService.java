package com.jk.service;

import com.jk.model.LoginUser;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 19:38
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@FeignClient(value = "server-zy")
public interface UserService {
       @RequestMapping("LoginUser")
       LoginUser loginUser(String username);
}
