package seater.order.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import seater.order.entity.Order;

import java.util.List;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select(
    "<script>select t0.* from order t0 " +
    //add here if need left join
    "where 1=1" +
    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
    "<when test='userId!=null and userId!=&apos;&apos; '> and t0.user_id=#{userId}</when> " +
    "<when test='productId!=null and productId!=&apos;&apos; '> and t0.product_id=#{productId}</when> " +
    "<when test='count!=null and count!=&apos;&apos; '> and t0.count=#{count}</when> " +
    "<when test='money!=null and money!=&apos;&apos; '> and t0.money=#{money}</when> " +
    "<when test='status!=null and status!=&apos;&apos; '> and t0.status=#{status}</when> " +
    //add here if need page limit
    //" limit ${page},${limit} " +
    " </script>")
    List<Order> pageAll(Order queryParamDTO, int page, int limit);

    @Select("<script>select count(1) from order t0 " +
    //add here if need left join
    "where 1=1" +
    "<when test='id!=null and id!=&apos;&apos; '> and t0.id=#{id}</when> " +
    "<when test='userId!=null and userId!=&apos;&apos; '> and t0.user_id=#{userId}</when> " +
    "<when test='productId!=null and productId!=&apos;&apos; '> and t0.product_id=#{productId}</when> " +
    "<when test='count!=null and count!=&apos;&apos; '> and t0.count=#{count}</when> " +
    "<when test='money!=null and money!=&apos;&apos; '> and t0.money=#{money}</when> " +
    "<when test='status!=null and status!=&apos;&apos; '> and t0.status=#{status}</when> " +
     " </script>")
    int countAll(Order queryParamDTO);

}