package com.asiainfo;

import java.util.HashMap;

/**
 * OOM——永久区溢出
 * 
 * @author zhangzhiwang
 * @date 2018年2月8日 下午3:17:23
 */
public class OOMPermGenSpace {
	public static void main(String[] args) throws ClassNotFoundException {
		//模拟OOM第二种情况——永久区溢出
		//运行参数：-XX:PermSize=2M -XX:MaxPermSize=2M
		for (int i = 0; i < 1000000; i++) {
			HashMap<String, Object> propertyMap = new HashMap<>();
			propertyMap.put("id", Class.forName("java.lang.Integer"));
			propertyMap.put("name", Class.forName("java.lang.String"));
			propertyMap.put("address", Class.forName("java.lang.String"));

			new CglibBean(propertyMap);
		}
	}
}
