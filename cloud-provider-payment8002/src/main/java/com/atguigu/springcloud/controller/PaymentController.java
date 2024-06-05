package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author jingchun
 * @create 2024-05-16 22:48
 */

@RestController
@Slf4j
public class PaymentController {


	@Value("${server.port}")
	private String serverPort;

	@Resource
	private PaymentServiceImpl paymentServiceImpl;

	/**
	 * 插入数据
	 * @param payment
	 * @return
	 */
	@PostMapping("/payment/create")
		public CommonResult<Payment> create(@RequestBody Payment payment){
		int result =paymentServiceImpl.create(payment);
		log.info("***插入返回结果："+result);
		if (result > 0){
			return new CommonResult(200,"插入数据库成功，端口号是\"+serverPort",result);
		}else{
			return new CommonResult(444,"插入数据库失败",null);
		}

	}

	/**
	 *  查询
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPaymentByID(@PathVariable Long id){

		Payment payment =paymentServiceImpl.getPaymentByID(id);
		if(payment!=null){
			return new CommonResult(200,"查询成功，端口号是："+serverPort,payment);
		}else{
			return new CommonResult(444,"没有对应记录，查询ID："+id,null);
		}

	}

}
