package com.jk.service;

import com.jk.model.Book;
import com.jk.model.Express;
import com.jk.model.MyOrder;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:52
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface ExpressService {
@RequestMapping(value="/queryNowStatus1")
    List<Express> queryNowStatus1(String numbers);

@RequestMapping(value="/queryBookComment")
    List<Book> queryBookComment(String orderallid);

}
