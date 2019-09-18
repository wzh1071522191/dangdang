package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.BookType;
import com.jk.service.BookService;
import com.jk.util.AlYunOssUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("toAddPage")
    public String toAddPage(){
        return "zsg/addBook";
    }

    @RequestMapping("queryBookType")
    @ResponseBody
    public List<BookType> queryBookType(){
        List<BookType> list =bookService.queryBookType();
        return list;
    }
    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("upLoadFile")
    @ResponseBody
    public String uploadImg(MultipartFile imgName)throws IOException {
        if (imgName == null || imgName.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        AlYunOssUtil ossClient=new AlYunOssUtil();
        String name = ossClient.uploadImg2Oss(imgName);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        System.out.println(split[0]);
        return split[0];
    }

    @RequestMapping("addBook")
    @ResponseBody
    public String addBook( Book book){
        return bookService.addBook(book);
    }

    @RequestMapping("delBook")
    @ResponseBody
    public void delBook(Integer id){
        bookService.delBook(id);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus(Book book){
        return bookService.updateStatus(book);
    }

    @RequestMapping("toUpdatePage")
    @ResponseBody
    public ModelAndView toUpdatePage(Integer id){
        ModelAndView mv = new ModelAndView();
        Book book =bookService.queryBookById(id);
        mv.addObject ("b",book);
        mv.setViewName ("zsg/updateBook");
        return mv;
    }



}
