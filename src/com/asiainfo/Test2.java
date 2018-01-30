package com.asiainfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试跟踪参数
 * 
 * @author zhangzhiwang
 * @date 2018年1月30日 下午11:29:16
 */
public class Test2 {
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			new Test2();
//			System.gc();
		}
		Map map = new HashMap<>();
		map.put(1, 1);
	}
}
