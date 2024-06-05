package com.atguigu.srpingcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.srpingcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jingchun
 * @create 2024-06-01 14:51
 */

@RestController
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id")  Long id){

		return paymentFeignService.getPayment(id);
	};


}
