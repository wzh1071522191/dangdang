package com.jk.service;

import com.jk.dao.BookDao;
import com.jk.model.Book;
import com.jk.model.BookType;
import com.jk.util.ParameUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 16:24
 * @Description :   业务层
 * @Package :   com.jk.service
 */
@RestController
public class BookServiceImpl implements BookServiceApi{

    @Autowired
    private BookDao bookDao;


    @Override
    public HashMap<String, Object> queryBook(ParameUtil parameUtil) {
        Integer page = parameUtil.getPageNumber();
        parameUtil.setPageNumber((page-1)*parameUtil.getPageSize());
        Integer total = bookDao.queryBookCount();
        List<Book> queryBookList =bookDao.queryBookList(parameUtil);
        HashMap<String, Object> hashMap =new HashMap<String, Object>();
        hashMap.put("total",total);
        hashMap.put("rows",queryBookList);
        return hashMap;
    }

    @Override
    public List<BookType> queryBookType (Integer pid) {
        return bookDao.queryBookType(pid);
    }

    @Override
    public Book addBook (Book book) {
        if (book.getBookId () == null||"".equals (book.getBookId ())) {
            bookDao.addBook(book);
            Integer id= book.getBookId ();
            Book book1 = bookDao.queryBookByIdEs (id);
            return book1;
        }else {
            bookDao.updateBook(book);
            Book book1 = bookDao.queryBookByIdEs (book.getBookId ());
            return book1;
        }

    }

    @Override
    public void delBook (Integer id) {
        bookDao.delBook(id);
    }

    @Override
    public Book updateStatus (Book book) {
        bookDao.updateStatus(book);
        Book book1 = bookDao.queryBookByIdEs (book.getBookId ());
        return book1;
    }

    @Override
    public Book queryBookById (Integer id) {
        return bookDao.queryBookById(id);
    }
}
