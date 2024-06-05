package com.atguigu.srpingcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jingchun
 * @create 2024-06-01 14:50
 */


@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

	@GetMapping("/payment/get/{id}")
	CommonResult<Payment>  getPayment(@PathVariable("id") Long id);
}
