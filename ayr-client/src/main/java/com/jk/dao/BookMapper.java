package com.jk.dao;

import com.jk.model.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 20:40
 * @description：
 * @package ：com.jk.dao
 * @version:
 */
public interface BookMapper {
   @Select("select * from book where bookid in(${orderallid})")
    List<Book> queryBookComment(@Param("orderallid") String orderallid);
    @Select("select * from book where bookid =#{bookid}")
    Book queryBookById(@Param("bookid") Integer bookid);
}
