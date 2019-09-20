package com.jk.service;

import com.jk.dao.BookDao;
import com.jk.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
        hashMap.put ("book",bookList);
        hashMap.put ("b",bookList1);
        return hashMap;
    }

    @Override
    public Book queryBookById (Integer bookId) {

        return bookDao.queryBookById (bookId);
    }


}
