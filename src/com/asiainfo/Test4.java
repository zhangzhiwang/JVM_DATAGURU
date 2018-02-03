package com.asiainfo;

/**
 * 测试不同参数对内存分配的影响	
 * 
 * @author zhangzhiwang
 * @date 2018年2月3日 下午8:00:18
 */
public class Test4 {
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}
	}
}
