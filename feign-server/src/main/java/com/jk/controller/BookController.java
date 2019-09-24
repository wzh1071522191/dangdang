package com.jk.controller;

import com.jk.service.BookService;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 14:10
 * @Description :   商品书籍控制层
 * @Package :   com.jk.controller
 */
@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("toBook")
    public String toBook(){

        return "zsg/book";
    }
    @RequestMapping("queryBook")
    @ResponseBody
    public HashMap<String,Object> queryBook(@RequestBody ParameUtil parameUtil){
        return bookService.queryBook(parameUtil);
    }



}
