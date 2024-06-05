package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jingchun
 * @create 2024-05-17 19:29
 */

@RestController
@Slf4j
public class OrderController {


	public static final String PAYMENT_SERVER_URL ="http://CLOUD-PAYMENT-SERVICE";

	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment){

//		因为restTemplate发送的post请求是json格式的 json格式接收要用@requestBody注解
		return restTemplate.postForObject(PAYMENT_SERVER_URL+"/payment/create",payment,CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult getPayment(@PathVariable Long id){

		return restTemplate.getForObject(PAYMENT_SERVER_URL+"/payment/get/"+id,CommonResult.class);
	}


	@GetMapping("consumer/payment/getForEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable Long id){
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_SERVER_URL+"/payment/get/"+id,
				CommonResult.class);
		log.info("-------------------------------------------------------------");
		log.info("entity为:{}",entity);
		log.info("entity.getbody为:{}",entity.getBody());
		log.info("entity.getHeaders:{}",entity.getHeaders());
		log.info("entity.getStatusCode:{}",entity.getStatusCode());
		log.info("-------------------------------------------------------------");
		if(entity.getStatusCode().is2xxSuccessful()){
			return entity.getBody();
		}else{
			return new CommonResult<>(444,"操作失败");
		}
	}

}
