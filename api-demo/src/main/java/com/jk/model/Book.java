package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 18:27
 * @Description :   书籍
 * @Package :   com.jk.model
 */
@Data
public class Book {

    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private Integer bookTypeId;

    private String press;

    private String bookContent;

    private Double bookPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bookDate;

    private Integer bookStatus;

    private Integer bookCount;

    private Double hits;

    private Integer bookStar;

    private String bookImg1;

    private String bookImg2;

    private String bookImg3;

    private BookType bookType;
}
