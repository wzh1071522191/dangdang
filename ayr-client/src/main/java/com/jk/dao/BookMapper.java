package com.jk.dao;

import com.jk.model.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface BookMapper {
   @Select("select * from book where bookid in(${orderallid})")
    List<Book> queryBookComment(@Param("orderallid") String orderallid);
    @Select("select * from book where bookid =#{bookid}")
    Book queryBookById(@Param("bookid") Integer bookid);
    @Update("update book set bookStar=bookStar+1 where  bookid =#{bookid}")
    int updateCount(@Param("bookid") Integer bookid);
}
