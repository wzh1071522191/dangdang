package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.BookType;
import com.jk.model.LunBo;
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

    @Select ("SELECT * FROM booktype WHERE pid=#{pid}")
    List<BookType> queryBookType (Integer pid);

    Integer addBook (Book book);

    @Delete ("DELETE FROM book WHERE bookId=#{id}")
    void delBook (Integer id);

    void updateStatus (Book book);

    //@Select ("SELECT * FROM book b LEFT JOIN booktype bt ON b.booktypeid=bt.typeid WHERE bookid=#{id}")
    Book queryBookById (Integer id);

    void updateBook (Book book);

    Book queryBookByIdEs (Integer id);

    @Select ("SELECT * FROM book")
    List<Book> queryBookAll ();

    @Select ("SELECT * FROM book WHERE bookStatus =1")
    List<Book> queryBookStatus ();


    List<Book> queryBookLike ();

    List<Book> queryBookByType (Integer typeId);

    @Select ("SELECT * FROM book WHERE bookStatus=1  ORDER BY bookId DESC LIMIT 0,10")
    List<Book> queryListBook ();

    @Select ("SELECT * FROM lunbotu ")
    List<LunBo> queryImg ();

    @Select ("SELECT * FROM book WHERE bookTypeId=23")
    List<Book> queryBookByBookType (Integer bookTypeId);

    @Select ("SELECT * FROM book WHERE bookTypeId=23")
    List<Book> queryBookByBookTypeAll ();

    @Select ("SELECT * FROM book WHERE bookStatus=1 ORDER BY bookPrice DESC LIMIT 0,8")
    List<Book> bookList2 ();

    @Select ("SELECT * FROM book WHERE bookStatus=1 AND bookTypePid=2 LIMIT 0,8")
    List<Book> bookList3 ();

    @Select ("SELECT * FROM book WHERE bookStatus=1 AND bookTypePid=1 LIMIT 0,8")
    List<Book> bookList4 ();

    @Select ("SELECT * FROM book WHERE bookStatus=1 AND bookTypePid=5")
    List<Book> bookChird ();

    @Select ("SELECT * FROM book WHERE bookStatus=1 AND bookTypePid=10")
    List<Book> bookKj ();
}
