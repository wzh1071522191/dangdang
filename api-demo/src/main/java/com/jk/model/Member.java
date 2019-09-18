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

import lombok.Data;

import java.io.Serializable;

/**
 * 会员信息表--xqt
 */
@Data
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
    private LoginUser loginUser;
    //===临时字段
    private Integer userids;
    private Integer dengjis;
    private Integer jifens;
    private String passwords;
    private String usernames;
    private String userphones;
    private Integer statuss;




}
