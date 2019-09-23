package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/20 15:15
 * @Description :   客户端业务层接口
 * @Package :   com.jk.service
 */
@FeignClient(value = "server-zsg")
public interface ConsumerBookService extends ConsumerBookServiceApi{
}
