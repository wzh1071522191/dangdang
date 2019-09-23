package com.jk.dao;

import com.jk.model.LunBo;
import com.jk.model.MyOrder;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface LbDao {

    Integer sumco(ParameUtil param);

    List<LunBo> querylblist(ParameUtil param);

    @Insert("insert into lunbotu (type,maxlength,minlength,paixu,status,img,addtime) values(#{o.type},#{o.maxlength},#{o.minlength},#{o.paixu},2,#{o.img},now())")
    void addlb(@Param("o") LunBo lb);
    @Update("update lunbotu set status=2 where lbid=#{id}")
    void upstu1(Integer id);
    @Update("update lunbotu set status=1 where lbid=#{id}")
    void upstu2(Integer id);
      @Delete("delete from lunbotu where lbid=#{lbid}")
    void shanimg(Integer lbid);
      @Select("select * from t_order  where orderdate >'2019-01-01' and orderdate<'2019-12-30'  limit #{pageNumber},#{pageSize}")
    List<MyOrder> querymouth(ParameUtil param);
    Integer sum1(ParameUtil param);

    List<Map<String, Object>> yuedan();

    List<Map<String, Object>> queryBingZhuang();

    List<Map<String, Object>> queryZhuzhuang();
@Select("select * from lunbotu where status=1")
    List<LunBo> getlbtu();

    Integer sumco2(ParameUtil param);

    List<MyOrder> querylblist2(ParameUtil param);

    List<MyOrder> exall();
}
