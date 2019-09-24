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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Double getHits() {
        return hits;
    }

    public void setHits(Double hits) {
        this.hits = hits;
    }

    public Integer getBookStar() {
        return bookStar;
    }

    public void setBookStar(Integer bookStar) {
        this.bookStar = bookStar;
    }

    public String getBookImg1() {
        return bookImg1;
    }

    public void setBookImg1(String bookImg1) {
        this.bookImg1 = bookImg1;
    }

    public String getBookImg2() {
        return bookImg2;
    }

    public void setBookImg2(String bookImg2) {
        this.bookImg2 = bookImg2;
    }

    public String getBookImg3() {
        return bookImg3;
    }

    public void setBookImg3(String bookImg3) {
        this.bookImg3 = bookImg3;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getBookTypePid() {
        return bookTypePid;
    }

    public void setBookTypePid(Integer bookTypePid) {
        this.bookTypePid = bookTypePid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTypeId=" + bookTypeId +
                ", press='" + press + '\'' +
                ", bookContent='" + bookContent + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookDate=" + bookDate +
                ", bookStatus=" + bookStatus +
                ", bookCount=" + bookCount +
                ", hits=" + hits +
                ", bookStar=" + bookStar +
                ", bookImg1='" + bookImg1 + '\'' +
                ", bookImg2='" + bookImg2 + '\'' +
                ", bookImg3='" + bookImg3 + '\'' +
                ", bookType=" + bookType +
                ", typeName='" + typeName + '\'' +
                ", buyCount=" + buyCount +
                ", bookTypePid=" + bookTypePid +
                '}';
    }
}
