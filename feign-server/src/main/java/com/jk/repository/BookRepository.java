package com.jk.repository;

import com.jk.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/19 11:40
 * @Description :   es数据库
 * @Package :   com.jk.repository
 */
public interface BookRepository extends ElasticsearchCrudRepository<Book,Integer> {
}
