package com.jk.service;

import com.jk.model.Book;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @version :
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/20 15:18
 * @Description :   客户端API接口
 * @Package :   com.jk.service
 */
public interface ConsumerBookServiceApi {

    @RequestMapping("toIndex")
    HashMap<String,Object> queryBookAll ();

    @RequestMapping("toMessage")
    Book queryBookById (@RequestBody Integer bookId);

    @RequestMapping("queryBookByType")
    List<Book> queryBookByType (@RequestBody Integer typeId);

   /* @RequestMapping("toIndex")
    List<Book> queryBookStatus ();*/
}
