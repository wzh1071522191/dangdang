package com.jk.service;

import com.jk.model.LunBo;
import com.jk.model.MyOrder;
import com.jk.util.ParameUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface LunBoService {
    @RequestMapping("querylblist")
    Map lblist(@RequestBody  ParameUtil param);

    @RequestMapping("addlb")
    void addlb(@RequestBody LunBo lb);

    @RequestMapping("upstu1")
    void upstu1(@RequestBody Integer id);

    @RequestMapping("upstu2")
    void upstu2(@RequestBody Integer id);

    @RequestMapping("delImg")
    void shanimg(@RequestBody  Integer lbid);

    @RequestMapping("querymouthxl")
    Map<String, Object> querymouth(@RequestBody ParameUtil param);

    @RequestMapping("yuedan")
    List<Map<String, Object>> yuedan();

    @RequestMapping("queryBingZhuang")
    List<Map<String, Object>> queryBingZhuang();

    @RequestMapping("queryZhuzhuang")
    List<Map<String, Object>> queryZhuzhuang();

    @RequestMapping("getlbtu")
    List<LunBo> getlbtu();

    @RequestMapping("querymouthxl2")
    Map<String, Object> querymouth2(@RequestBody ParameUtil param);
    @RequestMapping("exportExcel2019")
    List<MyOrder> queryExportExcelGaikuangThree();

    @RequestMapping("querytu2")
    List<Map<String, Object>> yuedan2();

    @RequestMapping("getshushu")
    MyOrder getzong();

    @RequestMapping("exportExcelseven")
    List<MyOrder> queryExportExcelGaikuang7();

   /* @RequestMapping("xiaobing1")
    HashMap<String,Object> xiaobing1();
*/

}
