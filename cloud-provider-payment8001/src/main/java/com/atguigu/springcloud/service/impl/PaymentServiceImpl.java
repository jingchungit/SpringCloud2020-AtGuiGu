package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author jingchun
 * @create 2024-05-16 22:46
 */

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {

		if (payment.getSerial()!=null){
			return paymentDao.create(payment);
		}else{
			return 0;
		}
	}

	@Override
	public Payment getPaymentByID(Long id) {
		return paymentDao.getPaymentByID(id);
	}
}
