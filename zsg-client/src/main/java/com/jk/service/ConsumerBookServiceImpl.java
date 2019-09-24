package com.jk.service;

import com.jk.dao.BookDao;
import com.jk.model.Book;
import com.jk.model.LunBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/20 15:19
 * @Description :   客户端业务层
 * @Package :   com.jk.service
 */
@RestController
public class ConsumerBookServiceImpl implements ConsumerBookServiceApi{

    @Autowired
    private BookDao bookDao;

    @Override
    public HashMap<String,Object> queryBookAll () {
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        List<Book> bookList = bookDao.queryBookAll ();
        List<Book> bookList1 = bookDao.queryBookStatus ();
      //  List<Book> bookList2 = bookDao.queryBookLike ();
        hashMap.put ("book",bookList);
        hashMap.put ("b",bookList1);
        return hashMap;
    }

    @Override
    public Book queryBookById (Integer bookId) {

        return bookDao.queryBookById (bookId);
    }

    @Override
    public List<Book> queryBookByType (Integer typeId) {

        return bookDao.queryBookByType(typeId);
    }

    @Override
    public HashMap<String, Object> queryAll (Integer bookTypeId) {
        List<Book> bookList = bookDao.queryListBook ();
        List<LunBo> lunBos = bookDao.queryImg ();
        List<Book> bookList1=new ArrayList<> ();
        List<Book> bookList2 = bookDao.bookList2();
        List<Book> bookList3=bookDao.bookList3();
        List<Book> bookList4=bookDao.bookList4();
        List<Book> bookChird=bookDao.bookChird();
        List<Book> bookKj=bookDao.bookKj();
        if(bookTypeId==0||bookTypeId==null){
            bookList1=bookDao.queryBookByBookTypeAll ();
        }else {
            bookList1=bookDao.queryBookByBookType (bookTypeId);
        }

        HashMap<String, Object> hashMap = new HashMap<> ();
        hashMap.put("blist",bookList);
        hashMap.put ("img",lunBos);
        hashMap.put ("bk1",bookList1);
        hashMap.put ("bk2",bookList2);
        hashMap.put ("bk3",bookList3);
        hashMap.put ("bk4",bookList4);
        hashMap.put ("kj",bookKj);
        hashMap.put ("bookChird",bookChird);
        return hashMap;
    }

    /*@Override
    public List<Book> queryBook (Integer bookTypeId) {
        return bookDao.queryBookByBookType (bookTypeId);
    }*/


}
