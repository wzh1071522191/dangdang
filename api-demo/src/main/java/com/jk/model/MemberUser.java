/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: MemberUser
 * Author:   薛琪陶
 * Date:     2019/9/19 0019 17:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

public class MemberUser implements Serializable {
    private static final long serialVersionUID = -1276509982996208347L;
    private Integer userid;
    private String username;
    private String userphone;
    private String password;
    private Integer jifen;
    private Integer dengji;
    private Integer status;

    //临时
    private String memberdetail;//会员简介
    private String memberzhengjian;//会员证件号
    private String memberemail;//会员邮箱
    private String memberarea;//会员所在地详细信息
    private Integer memberolds;//会员年龄
    private String memberaihao;//会员爱好

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getJifen() {
        return jifen;
    }

    public void setJifen(Integer jifen) {
        this.jifen = jifen;
    }

    public Integer getDengji() {
        return dengji;
    }

    public void setDengji(Integer dengji) {
        this.dengji = dengji;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemberdetail() {
        return memberdetail;
    }

    public void setMemberdetail(String memberdetail) {
        this.memberdetail = memberdetail;
    }

    public String getMemberzhengjian() {
        return memberzhengjian;
    }

    public void setMemberzhengjian(String memberzhengjian) {
        this.memberzhengjian = memberzhengjian;
    }

    public String getMemberemail() {
        return memberemail;
    }

    public void setMemberemail(String memberemail) {
        this.memberemail = memberemail;
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

    public String getMemberaihao() {
        return memberaihao;
    }

    public void setMemberaihao(String memberaihao) {
        this.memberaihao = memberaihao;
    }

    @Override
    public String toString() {
        return "MemberUser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userphone='" + userphone + '\'' +
                ", password='" + password + '\'' +
                ", jifen=" + jifen +
                ", dengji=" + dengji +
                ", status=" + status +
                ", memberdetail='" + memberdetail + '\'' +
                ", memberzhengjian='" + memberzhengjian + '\'' +
                ", memberemail='" + memberemail + '\'' +
                ", memberarea='" + memberarea + '\'' +
                ", memberolds=" + memberolds +
                ", memberaihao='" + memberaihao + '\'' +
                '}';
    }
}
