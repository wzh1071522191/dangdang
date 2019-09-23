package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.Express;
import com.jk.model.MyOrder;
import com.jk.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:49
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
public class ExpressController {
    @Autowired
    private ExpressService expressservice;
    @RequestMapping("queryNowStatus1")
    @ResponseBody
    public List<Express> queryNowStatus1(@RequestParam  String numbers, Model model) {
        System.out.println(numbers+"++++++++++++++++");
        return expressservice.queryNowStatus1(numbers);
    }
    @RequestMapping("queryBookComment")
    @ResponseBody
    public List<Book>  queryBookComment(@RequestParam String  orderallid){
        System.out.println("+++++++++"+orderallid);
        return expressservice.queryBookComment(orderallid);
    }


}

