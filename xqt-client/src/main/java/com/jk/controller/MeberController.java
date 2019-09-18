/**
 * Copyright (C), 2015-2019, 金科有限公司
 * FileName: MeberController
 * Author:   薛琪陶
 * Date:     2019/9/17 0017 22:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.mapper.MeberMapper;
import com.jk.service.MeberServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeberController implements MeberServiceApi{

    @Autowired
    private MeberMapper meberMapper;




}
