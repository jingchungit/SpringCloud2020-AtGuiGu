package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jingchun
 * @create 2024-05-16 20:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {

	private Long id;
	private String serial;


}
