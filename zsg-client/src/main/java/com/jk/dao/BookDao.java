package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.BookType;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select ("SELECT * FROM booktype")
    List<BookType> queryBookType ();

    void addBook (Book book);

    @Delete ("DELETE FROM book WHERE bookid=#{id}")
    void delBook (Integer id);

    void updateStatus (Book book);

    @Select ("SELECT * FROM book WHERE bookid=#{id}")
    Book queryBookById (Integer id);

    void updateBook (Book book);
}
