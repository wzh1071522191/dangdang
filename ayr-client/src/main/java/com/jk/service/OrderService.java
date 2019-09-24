package com.jk.service;

import com.jk.model.Book;
import com.jk.util.ParameUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 10:22
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface OrderService {
    @RequestMapping(value="/queryOrderAll")
    Map queryOrderAll(@RequestBody ParameUtil parm);
    @RequestMapping(value="/updFHStatus")
    void updFHStatus(@RequestParam Integer orderid, @RequestParam Integer orderstatus);
     @RequestMapping(value="/queryOrderById")
     MyOrder queryOrderById(Integer orderid);
    @RequestMapping(value="/queryOrderTK")
    Map queryOrderTK(@RequestBody ParameUtil parm);
    @RequestMapping(value="/queryOrderZF")
    Map queryOrderZF(@RequestBody ParameUtil parm);
    @RequestMapping(value="/queryOrderFH")
    Map queryOrderFH(@RequestBody ParameUtil parm);
    @RequestMapping(value="/queryBookById")
    Book queryBookById(@RequestParam Integer bookid);
   /* @RequestMapping(value="/queryMyOrder")
    Map queryMyOrder(@RequestBody ParameUtil parm);*/
}
