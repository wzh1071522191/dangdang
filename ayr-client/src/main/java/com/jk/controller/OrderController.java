package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.MyOrder;
import com.jk.service.OrderService;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-17 20:53
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderservice;
    @RequestMapping("queryOrderAll")
    @ResponseBody
    public Map queryOrderAll(@RequestBody ParameUtil parm){
        System.out.println(parm.getTypename());
        return orderservice.queryOrderAll(parm);
    }
    @RequestMapping("queryOrderTK")
    @ResponseBody
    public Map queryOrderTK(@RequestBody ParameUtil parm){
        System.out.println(parm.getCarbrandid()+"tk");
        return orderservice.queryOrderTK(parm);
    }
    @RequestMapping("queryOrderZF")
    @ResponseBody
    public Map queryOrderZF(@RequestBody ParameUtil parm){
        System.out.println(parm.getCarbrandid()+"zf");
        return orderservice.queryOrderZF(parm);
    }
    @RequestMapping("queryOrderFH")
    @ResponseBody
    public Map queryOrderFH(@RequestBody ParameUtil parm){
        System.out.println(parm.getCarbrandid()+"fh");
        return orderservice.queryOrderFH(parm);
    }
    @RequestMapping("updFHStatus")
    @ResponseBody
    public void updFHStatus(@RequestParam Integer orderid, @RequestParam Integer orderstatus){
        orderservice.updFHStatus(orderid,orderstatus);
    }
    @RequestMapping("queryOrderById")
    @ResponseBody
    public MyOrder queryOrderById(@RequestParam Integer orderid){
        return orderservice.queryOrderById(orderid);
    }
    /*@RequestMapping("queryMyOrder")
    @ResponseBody
    public Map queryMyOrder(@RequestBody ParameUtil parm){
        return orderservice.queryMyOrder(parm);
    }*/
   @RequestMapping("queryBookById")
    @ResponseBody
    public Book queryBookById(@RequestParam Integer bookid){
       return orderservice.queryBookById(bookid);
   }
    @RequestMapping("addMyOrder")
    @ResponseBody
    public void addMyOrder(@RequestBody MyOrder myOrder){
        orderservice.addMyOrder(myOrder);
    }
    @RequestMapping("updateCount")
    @ResponseBody
    public int updateCount(@RequestParam Integer bookid){
       int flag=orderservice.updateCount(bookid);
       return flag;
    }
    @RequestMapping("queryMyOrderById")
    @ResponseBody
    public List<MyOrder>  queryMyOrderById(@RequestParam int userid){
        return orderservice.queryMyOrderById(userid);
    }
    @RequestMapping("delOrder")
    @ResponseBody
    public void  delOrder(@RequestParam String ordernumber,@RequestParam Integer userid){
        orderservice.delOrder(ordernumber,userid);
    }
    @RequestMapping("queryMyOrderByStatus")
    @ResponseBody
    public List<MyOrder>  queryMyOrderByStatus(@RequestParam int userid){
        return orderservice.queryMyOrderByStatus(userid);
    }
}

