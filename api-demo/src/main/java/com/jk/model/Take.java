/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: Take
 * Author:   薛琪陶
 * Date:     2019/9/23 0023 19:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;
//收货地址表
public class Take implements Serializable {
    private static final long serialVersionUID = 930509597949855980L;

    private Integer id;
    private String takename;
    private String takearea;
    private String takeyoubian;
    private String takephone;
    private String takebeizhu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTakename() {
        return takename;
    }

    public void setTakename(String takename) {
        this.takename = takename;
    }

    public String getTakearea() {
        return takearea;
    }

    public void setTakearea(String takearea) {
        this.takearea = takearea;
    }

    public String getTakeyoubian() {
        return takeyoubian;
    }

    public void setTakeyoubian(String takeyoubian) {
        this.takeyoubian = takeyoubian;
    }

    public String getTakephone() {
        return takephone;
    }

    public void setTakephone(String takephone) {
        this.takephone = takephone;
    }

    public String getTakebeizhu() {
        return takebeizhu;
    }

    public void setTakebeizhu(String takebeizhu) {
        this.takebeizhu = takebeizhu;
    }

    @Override
    public String toString() {
        return "Take{" +
                "id=" + id +
                ", takename='" + takename + '\'' +
                ", takearea='" + takearea + '\'' +
                ", takeyoubian='" + takeyoubian + '\'' +
                ", takephone='" + takephone + '\'' +
                ", takebeizhu='" + takebeizhu + '\'' +
                '}';
    }
}
