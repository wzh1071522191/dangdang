package com.jk.service;

import com.jk.dao.LbDao;
import com.jk.model.LunBo;
import com.jk.model.MyOrder;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LbServiceImpl implements LunBoService{
    @Autowired
    private  LbDao lbdao;
    @Override
    public Map lblist(ParameUtil param) {
      Integer sum=lbdao.sumco(param);
      Integer page=param.getPageNumber();
      param.setPageNumber((page-1)*param.getPageSize());
        List<LunBo> list=lbdao.querylblist(param);
       Map<String,Object>map=new HashMap<>();
       map.put("rows",list);
       map.put("total",sum);
        return map;
    }

    @Override
    public void addlb(LunBo lb) {

        lbdao.addlb(lb);
    }

    @Override
    public void upstu1(Integer id) {
        lbdao.upstu1(id);
    }

    @Override
    public void upstu2(Integer id) {
        lbdao.upstu2(id);
    }

    @Override
    public void shanimg(Integer lbid) {
        lbdao.shanimg(lbid);
    }

    @Override
    public Map<String, Object> querymouth( ParameUtil param) {
        Integer sum=lbdao.sum1(param);
        Integer page=param.getPageNumber();
        param.setPageNumber((page-1)*param.getPageSize());
        List<MyOrder> list=lbdao.querymouth(param);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public List<Map<String, Object>> yuedan() {
        return lbdao.yuedan();
    }

    @Override
    public List<Map<String, Object>> queryBingZhuang() {
        return lbdao.queryBingZhuang();
    }

    @Override
    public List<Map<String, Object>> queryZhuzhuang() {
        return lbdao.queryZhuzhuang();
    }

    @Override
    public List<LunBo> getlbtu() {

        return lbdao.getlbtu();
    }

    @Override
    public Map<String, Object> querymouth2(ParameUtil param) {
        Integer sum=lbdao.sumco2(param);
        Integer page=param.getPageNumber();
        param.setPageNumber((page-1)*param.getPageSize());
        List<MyOrder> list=lbdao.querylblist2(param);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public List<MyOrder> queryExportExcelGaikuangThree() {
        return lbdao.exall();
    }

    @Override
    public List<Map<String, Object>> yuedan2() {
        return lbdao.yuedan2();
    }

    @Override
    public MyOrder getzong() {
        MyOrder order= lbdao.getshu();
        return order;
    }

    @Override
    public List<MyOrder> queryExportExcelGaikuang7() {
        return lbdao.exall7();
    }
/*
    @Override
    public HashMap<String,Object> xiaobing1() {
        HashMap<String,Object> hashMap =new HashMap<String,Object>();
        List<MyOrder> list=lbdao.xiaobing1();
        List<MyOrder> list1=lbdao.xiaobing2();
        hashMap.put("sumstu",list);
        hashMap.put("sumprice",list1);
        return hashMap;
    }*/



}
