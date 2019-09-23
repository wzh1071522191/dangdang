package com.jk.service;

import com.jk.model.Book;
import com.jk.util.ParameUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-19 20:55
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@FeignClient(value="server-ayr")
public interface OrderService {
@RequestMapping(value="/queryMyOrder")
    Map queryMyOrder(@RequestBody ParameUtil parm);
    @RequestMapping(value="/queryBookComment")
    List<Book> queryBookComment(@RequestParam String orderallid);
    @RequestMapping(value="/queryBookById")
    Book queryBookById(@RequestParam Integer bookid);
}
