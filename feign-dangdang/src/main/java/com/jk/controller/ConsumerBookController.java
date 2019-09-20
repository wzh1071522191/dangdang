package com.jk.controller;

import com.jk.model.Book;
import com.jk.service.ConsumerBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/20 15:13
 * @Description :   客户端控制层
 * @Package :   com.jk.controller
 */
@Controller
@RequestMapping("consumerBook")
public class ConsumerBookController {

    @Autowired
    private ConsumerBookService consumerBookService;

    @RequestMapping("toIndex")
    public String toIndex(Model model){
        HashMap<String,Object> hashMap =consumerBookService.queryBookAll();
       /* List<Book> bookList = consumerBookService.queryBookAll();
        List<Book> bookList2 = consumerBookService.queryBookStatus();*/
        /*ModelAndView mv = new ModelAndView();
        mv.addObject ("book",bookList);
        mv.setViewName ("Index");*/
        List<Book> bookList =(List<Book>) hashMap.get ("book");
        List<Book> bookList2=(List<Book>) hashMap.get ("b");
        model.addAttribute ("book",bookList);
        model.addAttribute ("b",bookList2);
        return "Index";
    }

    @RequestMapping("toMessage")
    public String toMessage(Integer bookId){
        Book book = consumerBookService.queryBookById(bookId);
        return "proinfo";
    }

}
