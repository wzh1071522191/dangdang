package com.jk.controller;


import com.jk.model.LunBo;
import com.jk.service.lbserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("lbt")
@Controller
public class mmcontroller {
    @Autowired
    private lbserver lbserv;
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("getlbtu")
    @ResponseBody
    public  List getlbtu(Model model){
        List<LunBo> list=lbserv.getlbtu();
        System.out.println(list.get(1).getImg());
        return list;
    }

}
