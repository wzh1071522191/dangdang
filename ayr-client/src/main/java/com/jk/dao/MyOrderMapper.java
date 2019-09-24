package com.jk.dao;

import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MyOrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(MyOrder record);

    int insertSelective(MyOrder record);

    MyOrder selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(MyOrder record);

    int updateByPrimaryKey(MyOrder record);
    @Select("select count(*) from t_order")
    long queryCount();
    List<MyOrder> queryList(@Param("stat") int stat, @Param("rows") Integer pageSize,@Param("parm") ParameUtil parm);

    void updFHStatus(@Param("orderid") Integer orderid, @Param("orderstatus")Integer orderstatus);
    @Select("select * from t_order where orderid=#{orderid}")
    MyOrder queryOrderById(@Param("orderid") Integer orderid);

    List<MyOrder> queryList1(@Param("stat") int stat, @Param("rows") Integer pageSize,@Param("parm") ParameUtil parm);

    List<MyOrder> queryList2(@Param("stat") int stat, @Param("rows") Integer pageSize,@Param("parm") ParameUtil parm);

    List<MyOrder> queryList3(@Param("stat") int stat, @Param("rows") Integer pageSize,@Param("parm") ParameUtil parm);

    void addMyOrder(MyOrder myOrder);
    @Select("select * from t_order where userid=#{userid} and orderstatus=4" )
    List<MyOrder> queryMyOrderById(@Param("userid") int userid);
    @Update("update t_order set orderstatus=31 where userid=#{userid} and ordernumber=#{ordernumber}")
    void delOrder(@Param("ordernumber") String ordernumber,@Param("userid") Integer userid);
    @Select("select * from t_order where userid=#{userid} and orderstatus=31" )
    List<MyOrder> queryMyOrderByStatus(@Param("userid")int userid);
}