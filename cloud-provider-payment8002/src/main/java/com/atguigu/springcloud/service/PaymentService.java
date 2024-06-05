package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author jingchun
 * @create 2024-05-16 22:45
 */


public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentByID(@Param("id") Long id);

}
