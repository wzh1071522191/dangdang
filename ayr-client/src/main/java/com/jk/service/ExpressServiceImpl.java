package com.jk.service;

import com.jk.dao.BookMapper;
import com.jk.model.Book;
import com.jk.model.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-09-18 18:56
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@Service
public class ExpressServiceImpl implements  ExpressService{
@Autowired
private MongoTemplate mongoTemplate;
@Autowired
private BookMapper bookmapper;


    @Override
    public List<Express> queryNowStatus1(String numbers) {
        Criteria c=new  Criteria();
        Query query=new Query();
        c.and("numbers").is(numbers);
        query.addCriteria(c);
        return mongoTemplate.find(query,Express.class, "Express");
    }

   @Override
    public List<Book> queryBookComment(String orderallid) {
       System.out.println("service++++++++++"+orderallid);
        return bookmapper.queryBookComment(orderallid);
    }
}

