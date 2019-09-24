package com.jk.service;

import com.jk.model.Book;
import com.jk.model.MyOrder;
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
    @RequestMapping(value="/addMyOrder")
    void addMyOrder(@RequestBody MyOrder myOrder);
    @RequestMapping(value="/updateCount")
    int updateCount(@RequestParam Integer bookid);
    @RequestMapping(value="/queryMyOrderById")
    List<MyOrder> queryMyOrderById(@RequestParam int userid);
    @RequestMapping(value="/delOrder")
    void delOrder(@RequestParam String ordernumber,@RequestParam Integer userid);
    @RequestMapping(value="/queryMyOrderByStatus")
    List<MyOrder> queryMyOrderByStatus(@RequestParam  int userid);
}
