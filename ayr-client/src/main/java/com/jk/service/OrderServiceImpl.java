package com.jk.service;

import com.jk.dao.BookMapper;
import com.jk.dao.MyOrderMapper;
import com.jk.model.Book;
import com.jk.model.MyOrder;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 10:23
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@Service
public class OrderServiceImpl implements  OrderService{
@Autowired
private MyOrderMapper ordermapper;
@Autowired
private BookMapper bookmapper;
    @Override
    public Map queryOrderAll(ParameUtil parm) {
        System.out.println(parm.getPageNumber()+"fffffffffffffff"+parm.getPageSize());
        long count = ordermapper.queryCount();
        int stat = (parm.getPageNumber() - 1) * parm.getPageSize();
        List<MyOrder> list = ordermapper.queryList(stat, parm.getPageSize(), parm);
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }

    @Override
    public void updFHStatus(Integer orderid, Integer orderstatus) {
        ordermapper.updFHStatus(orderid,orderstatus);
    }

    @Override
    public MyOrder queryOrderById(Integer orderid) {
        return ordermapper.queryOrderById(orderid);
    }

    @Override
    public Map queryOrderTK(ParameUtil parm) {
        System.out.println(parm.getPageNumber()+"fffffffffffffff"+parm.getPageSize());
        long count = ordermapper.queryCount();
        int stat = (parm.getPageNumber() - 1) * parm.getPageSize();
        List<MyOrder> list = ordermapper.queryList1(stat, parm.getPageSize(), parm);
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }

    @Override
    public Map queryOrderZF(ParameUtil parm) {
        System.out.println(parm.getPageNumber()+"fffffffffffffff"+parm.getPageSize());
        long count = ordermapper.queryCount();
        int stat = (parm.getPageNumber() - 1) * parm.getPageSize();
        List<MyOrder> list = ordermapper.queryList2(stat, parm.getPageSize(), parm);
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }

    @Override
    public Map queryOrderFH(ParameUtil parm) {
        System.out.println(parm.getPageNumber()+"fffffffffffffff"+parm.getPageSize());
        long count = ordermapper.queryCount();
        int stat = (parm.getPageNumber() - 1) * parm.getPageSize();
        List<MyOrder> list = ordermapper.queryList3(stat, parm.getPageSize(), parm);
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }

    @Override
    public Book queryBookById(Integer bookid) {
        return bookmapper.queryBookById(bookid);
    }

    @Override
    public void addMyOrder(MyOrder myOrder) {
        ordermapper.addMyOrder(myOrder);
    }

    @Override
    public int updateCount(Integer bookid) {
        int flag=bookmapper.updateCount(bookid);

        if(flag>0){
             return 1;
        }
        return 0;
    }

    @Override
    public List<MyOrder> queryMyOrderById(int userid) {
        return ordermapper.queryMyOrderById(userid);
    }

    @Override
    public void delOrder(String ordernumber, Integer userid) {
        ordermapper.delOrder(ordernumber,userid);
    }

    @Override
    public List<MyOrder> queryMyOrderByStatus(int userid) {
        return ordermapper.queryMyOrderByStatus(userid);
    }

   /* @Override
    public Map queryMyOrder(ParameUtil parm) {
        System.out.println(parm.getPageNumber()+"fffffffffffffff"+parm.getPageSize());
        long count = ordermapper.queryCount();
        int stat = (parm.getPageNumber() - 1) * parm.getPageSize();
        List<MyOrder> list = ordermapper.queryMyOrder(stat, parm.getPageSize(), parm);
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }*/
}

