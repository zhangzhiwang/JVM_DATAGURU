package com.asiainfo;

/**
 * 测试maxMemory、freeMemory、totalMemory
 * 
 * @author zhangzhiwang
 * @date 2018年1月31日 上午12:15:58
 */
public class Test3 {
	public static void main(String[] args) {
		System.out.println("Xmx:" + (Runtime.getRuntime().maxMemory()/1024/1024) + "M");//可以理解为Xmx的值
		System.out.println("free mem:" + (Runtime.getRuntime().freeMemory()/2014/1024) + "M");
		System.out.println("total mem:" + (Runtime.getRuntime().totalMemory()/1024/1024) + "M");//可以理解为Xms的值
		System.out.println("----------------");
		
		byte[] b = new byte[8 * 1024 * 1024];
		System.out.println("Xmx:" + (Runtime.getRuntime().maxMemory()/1024/1024) + "M");
		System.out.println("free mem:" + (Runtime.getRuntime().freeMemory()/2014/1024) + "M");
		System.out.println("total mem:" + (Runtime.getRuntime().totalMemory()/1024/1024) + "M");
	}
}
