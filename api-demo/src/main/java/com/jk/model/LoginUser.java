package com.jk.model;

import lombok.Data;

import javax.crypto.SecretKey;
import java.io.Serializable;

/**
 * @author ： 朱友
 * @date ：Created in 2019/9/17 19:46
 * @description：
 * @package ：com.jk.service.model
 * @version:
 */
@Data
public class LoginUser  implements Serializable {
    private static final long serialVersionUID = 5668497656756245456L;

    private  Integer userid;
    private  String password;
    private  String username;
    private String userphone;//用户手机号
    private Integer dengji;//用户等级
    private Integer jifen;//用户积分
    private Integer status;//用户状态


}
