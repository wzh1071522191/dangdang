package com.jk.service;

import com.jk.util.ParameUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 16:20
 * @Description :   书籍公共接口
 * @Package :   com.jk.service
 */
public interface BookServiceApi {


    @RequestMapping("queryBook")
    HashMap<String, Object> queryBook (@RequestBody ParameUtil parameUtil);
}
