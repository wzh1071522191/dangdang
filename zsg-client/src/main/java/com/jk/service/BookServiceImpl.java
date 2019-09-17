package com.jk.service;

import com.jk.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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


}
