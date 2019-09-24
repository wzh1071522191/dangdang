package com.jk.controller;

import com.jk.model.*;
import com.jk.service.OrderService;
import com.jk.util.OrderCodeFactory;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-19 20:42
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    private RedisTemplate<String,Showorder> redisTemplate;
    @Autowired
    private RedisTemplate<String ,String > redisTemplate1;
    @Autowired
    private OrderService orderservice;
    @Autowired
    private MongoTemplate mongoTemplate;

@RequestMapping("showMyOrder")
    public String showMyOrder(){
      return "vipOrder";
}
/*@RequestMapping("addMyOrder")
@ResponseBody
    public void  addMyOrder(HttpSession session){
    int userid=1;
    String key="myorder"+userid;
    MyOrder order=new MyOrder();
    order.setBookcount(1);
    order.setBookname("booktest");
    redisTemplate.opsForList().leftPush(key,order);
}*/
@RequestMapping("addOrder")
@ResponseBody
public void addOrder(@RequestParam String  bookallid,@RequestParam Double orderprice,HttpSession session,@RequestParam Integer bookcount){
    int userid=1;
    String orderCode = OrderCodeFactory.getOrderCode((long) userid);
    String key="myorder"+userid;

    System.out.println(orderCode);
    List<Showorder> list=new ArrayList<>();
    MyOrder myOrder =new MyOrder();
    Showorder showorder =new Showorder();
    showorder.setOrdernumber("12019092316513002191297750097159");
    myOrder.setBookcount(bookcount);
    myOrder.setOrderallid(bookallid);
    myOrder.setOrdernumber("12019092316513002191297750097159");
    myOrder.setOrderprice(orderprice);
    myOrder.setOrderdate(new Date());
    myOrder.setOrderstatus(1);
    showorder.setMyorder(myOrder);
    list.add(showorder);
    redisTemplate.opsForList().leftPush(key,showorder);
}
@RequestMapping("queryMyOrder")
    public String  queryMyOrder(HttpSession session, Model model){
    List<Showorder> list =null;
    MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
    int userid=loginUser.getUserid();
    String key="myorder"+userid;
    List<Book> bookList =null;
    List<Showorder> list1=new ArrayList<>();
    if(redisTemplate.hasKey(key)){
        List<Showorder> Showorderlist = redisTemplate.opsForList().range(key, 0, -1);
        System.out.println(Showorderlist);
       for (Showorder showorder : Showorderlist) {
           Showorder showOrder =new Showorder();
            showOrder.setMyorder(showorder.getMyorder());
            showOrder.setOrdernumber(showorder.getOrdernumber());
           System.out.println(showorder.getOrdernumber());
            String orderallid = showorder.getMyorder().getOrderallid();
            bookList = orderservice.queryBookComment(orderallid);
            showOrder.setBookList(bookList);
            list1.add(showOrder);
        }
    }
    model.addAttribute("list", list1);

/*    Map map = new HashMap();
    if(redisTemplate.hasKey(key)){
        list= redisTemplate.opsForList().range(key,(parm.getPageNumber()-1)*parm.getPageSize(),parm.getPageSize());
        map.put("rows", list);
        map.put("total", list.size());
    }*/

     return "vipOrder";
}

    @RequestMapping("toProinfo")
    public String toProinfo(@RequestParam Integer bookid,Model model){
        Book book =orderservice.queryBookById(bookid);
        //session 获取userID
        int userid=1;
    /*    LoginUser user  =new LoginUser();
        if(user==null){
            user.setUserid(0);
        }
        String key="userGwd"+userid;
        String userGWCvalue="";
        if(redisTemplate1.hasKey(key)){
            String s = redisTemplate1.opsForValue().get(key);
            userGWCvalue=s;
        }else{
            redisTemplate1.opsForValue().set(key,userGWCvalue);
        }
        model.addAttribute("userGWCvalue",userGWCvalue);*/
        model.addAttribute("book", book);
        return "proinfo";
    }
    @RequestMapping("toorder")
    public String  toorder(){
       return "order";
    }
    @RequestMapping("toorder2")
    public String  toorder2(){
       return "order2";
    }
 /*   @RequestMapping("queryGWD")
    @ResponseBody
    public void queryGWD(){
        int userid=1;
        int bookid=1;
        String key="userGwd"+userid;
        String userGWCvalue="";
        if(redisTemplate1.hasKey(key)){
            String s = redisTemplate1.opsForValue().get(key);
            userGWCvalue=s;
            for (int i=0;i<Integer.parseInt(userGWCvalue.split(",").toString());i++){
                 if(){}
            }
        }else{
            redisTemplate1.opsForValue().set(key,userGWCvalue);
        }

    }*/
 @RequestMapping("addGWD")
 @ResponseBody
 public  void userGWCvalue(@RequestParam String userGWCvalue,HttpSession session){
     MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
     int userid=loginUser.getUserid();
     String key="userGwd"+userid;
     redisTemplate1.delete(key);
     redisTemplate1.opsForValue().set(key, userGWCvalue);
     System.out.println("redisTemplate1"+redisTemplate1.opsForValue().get(key));
 }
    @RequestMapping("queryRedisGWC")
    public String  queryRedisGWC(Model model,HttpSession session,Integer bookid){
     int flag=0;
        flag=orderservice.updateCount(bookid);
       //session 获取userID
        MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
        int userid=loginUser.getUserid();
        Book book =orderservice.queryBookById(bookid);
        model.addAttribute("book", book);
        String key="userGwd"+userid;
        String userGWCvalue="";
        if(redisTemplate1.hasKey(key)){
            String s = redisTemplate1.opsForValue().get(key);
            userGWCvalue=s;
        }else{
            redisTemplate1.opsForValue().set(key,userGWCvalue);
        }
        System.out.println(userGWCvalue);
        System.out.println(book);
        model.addAttribute("userGWCvalue",userGWCvalue);

        return "proinfo";
    }
 /*  @RequestMapping("queryRedisGWC")
    @ResponseBody
    public String  queryRedisGWC(HttpSession session,Model model){
     int userid=1;
     String key="userGwd"+userid;
     String allid=",";
     int appendid=0;
       List list = null;
       if(redisTemplate.hasKey(key)){
           List range = redisTemplate.opsForList().range(key, 0, -1);
           if(range==null){
               UserGwd userGwd =new UserGwd();
               List<Gwd> gwdList =new ArrayList<>();
               Gwd gwd =new Gwd();
               gwdList.add(gwd);
               userGwd.setUserid(key);
               userGwd.setGwdList(gwdList);
               redisTemplate.opsForValue().set(key, userGwd);
         }

     }else{
         UserGwd userGwd =new UserGwd();
         List<Gwd> gwdList =new ArrayList<>();
         Gwd gwd =new Gwd();
         gwdList.add(gwd);
         userGwd.setUserid(key);
         userGwd.setGwdList(gwdList);
         redisTemplate.opsForValue().set(key, userGwd);
     }

      return "";
    }*/
    @RequestMapping("queryGwd")
    public String queryGwd(HttpSession session,Model model){
        MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
        String key="userGwd"+loginUser.getUserid();
        String gwcid="";
        if (redisTemplate1.hasKey(key)) {
            String s = redisTemplate1.opsForValue().get(key);
            gwcid=s;
        }
        List<Book> bookList =new ArrayList<>();
        if(gwcid!=null){
            String[] split = gwcid.split(",");

            for (int i=0 ;i<split.length;i++){
                  Book book =orderservice.queryBookById(Integer.parseInt(split[i]));
                  bookList.add(book);
            }
        }
        model.addAttribute("list", bookList);
        return  "order";
    }
    @RequestMapping("updMyOrderzt")
    public String  updMyOrderzt(HttpSession session){
        MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
        MyOrder myOrder = (MyOrder) session.getAttribute("myOrder");
        System.out.println("myorder-----in"+myOrder);
        String key="myorder"+loginUser.getUserid();
        List<Showorder> Showorderlist = redisTemplate.opsForList().range(key, 0, -1);
        List<Showorder>  Showorderlist1=new ArrayList<>();

        for (Showorder showorder : Showorderlist) {
            if(!"12019092316513002191297750097159".equals(showorder.getMyorder().getOrdernumber())){
                MyOrder myOrder1 =new MyOrder();
                Showorder showorder1 =new Showorder();
                System.out.println(showorder.getMyorder());
                myOrder1.setOrdernumber(showorder.getMyorder().getOrdernumber());
                myOrder1.setBookcount(showorder.getMyorder().getBookcount());
                myOrder1.setOrderallid(showorder.getMyorder().getOrderallid());
                myOrder1.setOrderprice(showorder.getMyorder().getOrderprice());
                myOrder1.setOrderdate(showorder.getMyorder().getOrderdate());
                myOrder1.setUserid(1);
                showorder1.setMyorder(myOrder1);
                System.out.println(showorder1);
                Showorderlist1.add(showorder1);
            }
        }

      /*  for (int i=0;i<Showorderlist.size();i++){
            if(Showorderlist.get(i).getOrdernumber()!=myOrder.getOrdernumber()){
                Showorder showorder =new Showorder();
                System.out.println(Showorderlist.get(i).getMyorder());
              //  showorder.setMyorder(Showorderlist.get(i).getMyorder());
                //Showorderlist1.add(showorder);
            }
        }*/
        redisTemplate.delete(key);
        System.out.println("successok");
        for (int i=0;i<Showorderlist1.size();i++){
            redisTemplate.opsForList().leftPush(key, Showorderlist1.get(i));
        }

        System.out.println("myorder-----in"+myOrder);
        int userid=1;
        orderservice.addMyOrder(myOrder);
         return "success";
    }
    @RequestMapping("queryqueryDAIFAHUO")
    public String queryqueryDAIFAHUO(HttpSession session,Model model){
        MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
           int userid=loginUser.getUserid();
          List<Showorder> Showorderlist = new ArrayList<>();
          List<MyOrder> myOrders =orderservice.queryMyOrderById(userid);
            for (int i=0;i<myOrders.size();i++){
                Showorder showorders=new Showorder();
                List<Book> bookList =orderservice.queryBookComment(myOrders.get(i).getOrderallid());
                showorders.setMyorder(myOrders.get(i));
                showorders.setBookList(bookList);
                Showorderlist.add(showorders);
            }
            model.addAttribute("fkOrder", Showorderlist);
           System.out.println(Showorderlist);
         return "FkOrder";
    }
    @RequestMapping("delOrder")
    @ResponseBody
    public void delOrder(HttpSession session,@RequestParam String ordernumber){
        MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
        Integer userid=loginUser.getUserid();
        orderservice.delOrder(ordernumber,userid);
    }
    @RequestMapping("queryTk")
    public String queryTk(HttpSession session,Model model){
        MemberUser loginUser = (MemberUser)session.getAttribute("loginUser");
        int userid=loginUser.getUserid();
        List<Showorder> Showorderlist = new ArrayList<>();
        List<MyOrder> myOrders =orderservice.queryMyOrderByStatus(userid);
        for (int i=0;i<myOrders.size();i++){
            Showorder showorders=new Showorder();
            List<Book> bookList =orderservice.queryBookComment(myOrders.get(i).getOrderallid());
            showorders.setMyorder(myOrders.get(i));
            showorders.setBookList(bookList);
            Showorderlist.add(showorders);
        }
        model.addAttribute("tkOrder", Showorderlist);
        System.out.println(Showorderlist);
        return "Tk";
    }
}

