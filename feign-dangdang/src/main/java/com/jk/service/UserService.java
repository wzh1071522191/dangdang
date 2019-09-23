package com.jk.service;

import com.jk.model.Comments;
import com.jk.model.LoginUser;
import com.jk.model.Tree;
import com.jk.util.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

     @RequestMapping("pinglun")
     List<Comments> pinglun();
}
