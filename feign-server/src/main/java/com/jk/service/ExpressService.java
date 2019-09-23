package com.jk.service;

import com.jk.model.Book;
import com.jk.model.Express;
import com.jk.model.MyOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:54
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@FeignClient(value="server-ayr")
public interface ExpressService {
    @RequestMapping(value="/queryNowStatus1")
    List<Express> queryNowStatus1(@RequestParam String numbers);


   @RequestMapping(value="/queryBookComment")
   List<Book> queryBookComment(@RequestParam String orderallid);

}
