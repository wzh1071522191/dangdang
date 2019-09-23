package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.Express;
import com.jk.model.ExpressDiscription;
import com.jk.model.MyOrder;
import com.jk.service.ExpressService;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:53
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("express")
public class ExpressController {
    @Autowired
    private ExpressService expressservice;
@Autowired
private OrderService orderservice;

    @RequestMapping("queryNowStatus")
    public  String queryNowStatus(@RequestParam String numbers, @RequestParam String  orderallid, Model model,@RequestParam Integer orderid){
        List<Express> list= expressservice.queryNowStatus1(numbers);
        List<Book> list2=expressservice.queryBookComment(orderallid);
        MyOrder myOrder=orderservice.queryOrderById(orderid);
        System.out.println(list);
       // for (int i=0;i<list.size();i++){
           // System.out.println(list.get(0).getDetails());
       // }
        List<ExpressDiscription> list1=new ArrayList<>();
     if(list.size()==0 || list==null){
          /*  Express express =new Express();
            ExpressDiscription expressDiscription1=new ExpressDiscription();
            expressDiscription1.setComment("抱歉，暂无物流信息");
            ArrayList<ExpressDiscription> expressDiscription =new ArrayList<>();
            expressDiscription.set(2,expressDiscription1);
            express.setDetails(expressDiscription);*/
         ExpressDiscription expressDiscription1=new ExpressDiscription();
         expressDiscription1.setComment("抱歉，暂无物流信息");
            list1.add(expressDiscription1);
            System.out.println(list1+"11111");
        }else {
         for (int i = 0; i < list.get(0).getDetails().size(); i++) {
             ExpressDiscription expressDiscription = new ExpressDiscription();
             if (list.get(0).getDetails().get(i).getComment() == null && "".equals(list.get(0).getDetails().get(i).getComment())) {
                 expressDiscription.setComment("");
             }
             if (list.get(0).getDetails().get(i).getPersonname() == null && "".equals(list.get(0).getDetails().get(i).getPersonname())) {
                 expressDiscription.setPersonname("");
             }
             if (list.get(0).getDetails().get(i).getPersonnumber() == null && "".equals(list.get(0).getDetails().get(i).getPersonnumber())) {
                 expressDiscription.setPersonname("");
             }
             expressDiscription.setComment(list.get(0).getDetails().get(i).getComment());
             expressDiscription.setPersonname(list.get(0).getDetails().get(i).getPersonname());
             expressDiscription.setPersonname(list.get(0).getDetails().get(i).getPersonnumber());
             list1.add(expressDiscription);
         }
     }
        //https://www.cnblogs.com/youxiu326/p/shoppingCart.html
        //https://blog.csdn.net/john_bh/article/details/54090835
        //https://cloud.tencent.com/developer/article/1152379
        //https://blog.csdn.net/SpringCYB/article/details/90400954
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(myOrder);
        model.addAttribute("explist", list1);
        model.addAttribute("booklist", list2);
        model.addAttribute("order",myOrder);
        return "order_detailed";
    }
@RequestMapping("aahh")
    public String aahh(){
         return "order_detailed";
    }

}

