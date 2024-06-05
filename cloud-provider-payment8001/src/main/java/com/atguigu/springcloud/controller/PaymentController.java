package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
	private PaymentService paymentService;

	@Resource
	private DiscoveryClient discoveryClient;


	/**
	 * 插入数据
	 * @param payment
	 * @return
	 */
	@PostMapping("/payment/create")
		public CommonResult<Payment> create(@RequestBody Payment payment){
		int result =paymentService.create(payment);
		log.info("***插入返回结果："+result);
		if (result > 0){
			return new CommonResult(200,"插入数据库成功，端口号是"+serverPort,result);
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

		Payment payment =paymentService.getPaymentByID(id);
		if(payment!=null){
			return new CommonResult(200,"查询成功，端口号是"+serverPort,payment);
		}else{
			return new CommonResult(444,"没有对应记录，查询ID："+id,null);
		}

	}

	@GetMapping("/payment/discovery")
	public Object discovery(){

		List<String> clientServices = discoveryClient.getServices();
		for (String service : clientServices) {
			log.info("*****element:"+service);
		}

		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
		}

		return this.discoveryClient;
	}

}
