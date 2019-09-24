package com.jk.controller;

import com.jk.model.MyOrder;
import com.jk.service.OrderService;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-17 20:53
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderservice;

    @RequestMapping("toshowOrderPay")
    public String toshowOrderPay() {
        return "Orderform";
    }

    @RequestMapping("toindex")
    public String toindex() {
        return "index";
    }

    @RequestMapping("queryOrderAll")
    @ResponseBody
    public Map queryOrderAll(@RequestBody ParameUtil parm) {
        System.out.println(parm.getPageSize() + "++++++++++++++++++++++++++++++++++++++++++++++++");
        return orderservice.queryOrderAll(parm);
    }

    @RequestMapping("updFHStatus")
    @ResponseBody
    public void updFHStatus(@RequestParam Integer orderid, @RequestParam Integer orderstatus) {
        orderservice.updFHStatus(orderid, orderstatus);
    }

    @RequestMapping("Refund")
    public String Refund() {
        return "Refund";
    }

    @RequestMapping("queryOrderTK")
    @ResponseBody
    public Map queryOrderTK(@RequestBody ParameUtil parm) {
        return orderservice.queryOrderTK(parm);
    }

    @RequestMapping("toAmounts")
    public String toAmounts() {
        return "Amounts";
    }
    @RequestMapping("queryOrderZF")
    @ResponseBody
    public Map queryOrderZF(@RequestBody ParameUtil parm) {
        System.out.println(parm.getPageSize() + "++++++++++++++++++++++++++++++++++++++++++++++++");
        return orderservice.queryOrderZF(parm);
    }

    @RequestMapping("queryOrderFH")
    @ResponseBody
    public Map queryOrderFH(@RequestBody ParameUtil parm) {
        System.out.println(parm.getPageSize() + "++++++++++++++++++++++++++++++++++++++++++++++++");
        return orderservice.queryOrderFH(parm);
    }
    @RequestMapping("transaction")
    public String transaction(){
        return "transaction";
    }
    @RequestMapping("Order_handling")
    public String Order_handling(){
        return "Order_handling";
    }

}

