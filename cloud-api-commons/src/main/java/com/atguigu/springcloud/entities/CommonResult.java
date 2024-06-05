package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jingchun
 * @create 2024-05-16 20:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>{

	private Integer code;
	private String message;
	private T data;

	public CommonResult(Integer code, String message) {
		this(code,message,null);
	}


}
