package com.jk.dao;

import com.jk.model.Book;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 16:26
 * @Description :   持久层
 * @Package :   com.jk.dao
 */
public interface BookDao {

    //@Select ("select count(*) from book")
    Integer queryBookCount ();

    //@Select ("select * from book limit #{pageNumber},#{pageSize}")
    List<Book> queryBookList (ParameUtil parameUtil);
}
