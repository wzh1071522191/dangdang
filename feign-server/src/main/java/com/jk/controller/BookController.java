package com.jk.controller;

import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
