package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @version :   1.0.0
 * @Author :  Zhangsongguang
 * @CreateDate :   2019/9/17 18:27
 * @Description :   书籍
 * @Package :   com.jk.model
 */
@Data
@Document(indexName = "bookindex",shards = 5,type = "book")
public class Book implements Serializable {

    @Id
    private Integer bookId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String bookName;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",copyTo = "copy")
    private String bookAuthor;
    @Field(type=FieldType.Integer)
    private Integer bookTypeId;

    private String press;

    private String bookContent;

    private Double bookPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Field(type = FieldType.Date,pattern = "yyyy-MM-dd")
    private Date bookDate;

    private Integer bookStatus;

    private Integer bookCount;

    private Integer hits;

    private Integer bookStar;

    private String bookImg1;

    private String bookImg2;

    private String bookImg3;

    private BookType bookType;

    private String typeName;

    private Integer buyCount;

    private Integer bookTypePid;
}
