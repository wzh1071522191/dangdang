package com.jk.service;

import com.jk.model.Book;
import com.jk.model.BookType;
import com.jk.util.ParameUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 16:20
 * @Description :   书籍公共接口
 * @Package :   com.jk.service
 */


public interface BookServiceApi {


    @RequestMapping("queryBook")
    HashMap<String, Object> queryBook (@RequestBody ParameUtil parameUtil);

    @RequestMapping("queryBookType")
    List<BookType> queryBookType (@RequestBody Integer pid);

    @RequestMapping("addBook")
    String addBook (@RequestBody Book book);

    @RequestMapping("delBook")
    void delBook (@RequestBody Integer id);

    @RequestMapping("updateStatus")
    String updateStatus (@RequestBody Book book);

    @RequestMapping("toUpdatePage")
    Book queryBookById (@RequestBody Integer id);
}
