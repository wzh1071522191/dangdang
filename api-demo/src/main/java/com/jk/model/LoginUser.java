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
public class LoginUser  implements Serializable {
    private static final long serialVersionUID = 5668497656756245456L;

    private  Integer userid;
    private  String password;
    private  String username;




    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "userid=" + userid +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
