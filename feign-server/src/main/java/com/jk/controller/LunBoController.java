package com.jk.controller;

import com.jk.model.LunBo;
import com.jk.service.lbserver;
import com.jk.util.AlYunOssUtil;
import com.jk.util.ParameUtil;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lb")
public class LunBoController {
      @Autowired
      private lbserver lbserv;

    @RequestMapping("querylunbo")
    public String tzlb(){
        return "lunbo";
    }

//查询轮播图
    @RequestMapping("querylblist")
    @ResponseBody
     public Map querylblist(@RequestBody ParameUtil param){

        return lbserv.lblist(param);
   }


//addImgJsp 跳转新增页面
    @RequestMapping("addImgJsp")
    public String addimgpage(){
        return "addimgpage";
    }


    //上传图片
    @RequestMapping("updaloadImg")
    @ResponseBody
    public String uploadImg(MultipartFile imgg)throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        AlYunOssUtil ossClient=new AlYunOssUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return split[0];
    }
    //
    @RequestMapping("addlb")
    @ResponseBody
    public void addlb(LunBo lb){
        lbserv.addlb(lb);
    }
///修改状态
    @RequestMapping("upstu1")
    @ResponseBody
public  void upstu(Integer id){
        lbserv.upstu1(id);
    }
//upstu2
@RequestMapping("upstu2")
@ResponseBody
public  void upstu2(Integer id){
    lbserv.upstu2(id);
}
//delImg
    @RequestMapping("delImg")
    @ResponseBody
   public  void shanimg(Integer lbid){
        lbserv.shanimg(lbid);
    }
//querymouthxl跳转图标
@RequestMapping("tubiao")
public String querym(){
    return "mqc/tuxing1";
}

//查询2019年所有数据
@RequestMapping("querymouthxl")
@ResponseBody
    public Map<String ,Object> querymouth(@RequestBody ParameUtil param){
        return lbserv.querymouth(param);
}
//2019每个月下单量
    @RequestMapping("yuexiadan")
    @ResponseBody
    public Map<String,Object> yuedan(){
        System.out.println("11111111111");
        List<Map<String,Object>> list = lbserv.yuedan();
        System.out.println("2222222222222");
        String[] week = new String[list.size()];
        int[] count = new int[list.size()];
        for (int i=0;i<list.size();i++){
            if(list.get(i).get("week").equals("01")){
                week[i] = "一月";
            }
            if(list.get(i).get("week").equals("02")){
                week[i] = "二月";
            }
            if(list.get(i).get("week").equals("03")){
                week[i] = "三月";
            }
            if(list.get(i).get("week").equals("04")){
                week[i] = "四月";
            }
            if(list.get(i).get("week").equals("05")){
                week[i] = "五月";
            }
            if(list.get(i).get("week").equals("06")){
                week[i] = "六月";
            }
            if(list.get(i).get("week").equals("07")){
                week[i] = "七月";
            }
            if(list.get(i).get("week").equals("08")){
                week[i] = "八月";
            }
            if(list.get(i).get("week").equals("09")){
                week[i] = "九月";
            }
            if(list.get(i).get("week").equals("10")){
                week[i] = "十月";
            }
            if(list.get(i).get("week").equals("11")){
                week[i] = "十一月";
            }
            if(list.get(i).get("week").equals("12")){
                week[i] = "十二月";
            }
            count[i] = Integer.parseInt(list.get(i).get("count").toString());
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("week",week);
        map.put("count",count);
        System.out.println(week);
        System.out.println(count);
        return map;
    }

//queryBingZhuang
//最近七天出售数量饼状图--全部数据
@RequestMapping("queryBingZhuang")
@ResponseBody
public List<Map<String, Object>> queryBingZhuang() {
    List<Map<String, Object>> list = lbserv.queryBingZhuang();
    List<Map<String, Object>> list1 = new ArrayList<>();
    for (Map<String, Object> map1 : list) {
        Map<String, Object> map = new HashMap<>();
        String shuliang = (String) map1.get("week");
        if (shuliang.equals("1")) {
            map.put("name", "周一");
        } else if (shuliang.equals("2")) {
            map.put("name", "周二");
        } else if (shuliang.equals("3")) {
            map.put("name", "周三");
        }
        else if (shuliang.equals("4")) {
            map.put("name", "周四");
        }
        else if (shuliang.equals("5")) {
            map.put("name", "周五");
        }
        else if (shuliang.equals("6")) {
            map.put("name", "周六");
        }
        else if (shuliang.equals("0")) {
            map.put("name", "周末");
        }
        map.put("y", map1.get("count"));
        map.put("sliced", "true");
        map.put("selected", "true");
        list1.add(map);
    }
    return list1;
}

//柱形图订单状态与数量
@RequestMapping("queryZhuzhuang")
@ResponseBody
public Map<String,Object> queryShoppingZhuxingByWeek(){
    List<Map<String,Object>> list = lbserv.queryZhuzhuang();
    String[] month = new String[list.size()];
    int[] count = new int[list.size()];
    for (int i=0;i<list.size();i++){
        if(list.get(i).get("status").equals("1")){
            month[i] = "付款失败";
        }
        if(list.get(i).get("status").equals("2")){
            month[i] = "已付款";
        }
        if(list.get(i).get("status").equals("3")){
            month[i] = "待发货";
        }
        if(list.get(i).get("status").equals("4")){
            month[i] = "已发货";
        }
        if(list.get(i).get("status").equals("5")){
            month[i] = "未收货";
        }
        if(list.get(i).get("status").equals("6")){
            month[i] = "收货失败";
        }
        if(list.get(i).get("status").equals("31")){
            month[i] = "发货前退款";
        }if(list.get(i).get("status").equals("32")){
            month[i] = "发货后退款";
        }

        count[i] = Integer.parseInt(list.get(i).get("count").toString());
    }
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("month",month);
    map.put("count",count);
    return map;
}

@RequestMapping("getlbtu")
@ResponseBody
    public  String getlbtu(Model model){
    List<LunBo>list=lbserv.getlbtu();
        model.addAttribute("list",list);
    System.out.println(list);
        return "index";
}
/*<div class="banner">
     <div id="kinMaxShow"  th:each="img:${list}">
      <div>
       <a href="#"><img th:src="${img.img}" height="360px"  /></a>
      </div>

     </div><!--kinMaxShow/-->
    </div><!--banner/-->
*/


}
