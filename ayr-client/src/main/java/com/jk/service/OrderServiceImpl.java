package com.jk.service;

import com.jk.dao.BookMapper;
import com.jk.dao.MyOrderMapper;
import com.jk.model.Book;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

