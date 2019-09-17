package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 14:19
 * @Description :   业务层接口
 * @Package :   com.jk.service
 */
@FeignClient(value = "server-zsg")
public interface BookService extends BookServiceApi{
}
