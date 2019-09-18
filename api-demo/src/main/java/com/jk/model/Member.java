/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: Member
 * Author:   薛琪陶
 * Date:     2019/9/17 0017 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 会员信息表--xqt
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 7928722219648579695L;

    private Integer id; //主键Id
    private String memberemail;//会员邮箱
    private String memberdetail;//会员简介
    private Integer memberstatus;//会员状态
    private String memberarea;//会员所在地详细信息
    private Integer memberolds;//会员年龄
    private Integer memberuserid;//会员与user表关联
    private String membertime;//会员创建时间
    private String memberzhengjian;//会员证件号
    private String memberaihao;//会员爱好

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberemail() {
        return memberemail;
    }

    public void setMemberemail(String memberemail) {
        this.memberemail = memberemail;
    }

    public String getMemberdetail() {
        return memberdetail;
    }

    public void setMemberdetail(String memberdetail) {
        this.memberdetail = memberdetail;
    }

    public Integer getMemberstatus() {
        return memberstatus;
    }

    public void setMemberstatus(Integer memberstatus) {
        this.memberstatus = memberstatus;
    }

    public String getMemberarea() {
        return memberarea;
    }

    public void setMemberarea(String memberarea) {
        this.memberarea = memberarea;
    }

    public Integer getMemberolds() {
        return memberolds;
    }

    public void setMemberolds(Integer memberolds) {
        this.memberolds = memberolds;
    }

    public Integer getMemberuserid() {
        return memberuserid;
    }

    public void setMemberuserid(Integer memberuserid) {
        this.memberuserid = memberuserid;
    }

    public String getMembertime() {
        return membertime;
    }

    public void setMembertime(String membertime) {
        this.membertime = membertime;
    }

    public String getMemberzhengjian() {
        return memberzhengjian;
    }

    public void setMemberzhengjian(String memberzhengjian) {
        this.memberzhengjian = memberzhengjian;
    }

    public String getMemberaihao() {
        return memberaihao;
    }

    public void setMemberaihao(String memberaihao) {
        this.memberaihao = memberaihao;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberemail='" + memberemail + '\'' +
                ", memberdetail='" + memberdetail + '\'' +
                ", memberstatus=" + memberstatus +
                ", memberarea='" + memberarea + '\'' +
                ", memberolds=" + memberolds +
                ", memberuserid=" + memberuserid +
                ", membertime='" + membertime + '\'' +
                ", memberzhengjian='" + memberzhengjian + '\'' +
                ", memberaihao='" + memberaihao + '\'' +
                '}';
    }
}
