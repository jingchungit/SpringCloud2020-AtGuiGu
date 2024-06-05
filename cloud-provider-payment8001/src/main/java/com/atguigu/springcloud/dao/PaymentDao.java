package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jingchun
 * @create 2024-05-16 20:25
 */

@Mapper
public interface PaymentDao {

  	int create(Payment payment);

   Payment getPaymentByID(@Param("id") Long id);

}
