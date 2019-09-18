/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: MeberController
 * Author:   薛琪陶
 * Date:     2019/9/18 0018 9:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.MeberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meber")
public class MeberController {

    @Autowired
    private MeberService meberService;



}
