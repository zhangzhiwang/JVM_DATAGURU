package com.asiainfo;

/**
 * 第一章测试
 * 
 * @author zhangzhiwang
 * @date 2018年1月30日 下午7:29:26
 */
public class Test1 {
	public static void main(String[] args) {
		int ii = 100_000_000;//jdk1.7以后才支持
		System.out.println(ii);
		System.out.println("---------------");
		
		int num = -6;
		System.out.println("-6的二进制表示为：");
		for(int i = 0; i < 32; i++) {
			int j = (num & 0x80000000 >>> i) >>> (31 - i);
			System.out.print(j);
		}
	}
	
	
}
