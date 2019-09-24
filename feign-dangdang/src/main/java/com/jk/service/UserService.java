package com.jk.service;

import com.jk.model.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

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

     @RequestMapping("pinglun")
     List<Comments> pinglun();
}
