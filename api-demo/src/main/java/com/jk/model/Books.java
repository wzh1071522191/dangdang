package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/20 19:27
 * @description：
 * @package ：com.jk.model
 * @version:
 */
public class Books implements Serializable {
    private static final long serialVersionUID = 1055534179681697786L;
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

    private String bookAudit;

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

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

    public String getBookAudit() {
        return bookAudit;
    }

    public void setBookAudit(String bookAudit) {
        this.bookAudit = bookAudit;
    }
}
