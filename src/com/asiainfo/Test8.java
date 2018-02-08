package com.asiainfo;

/**
 * 模拟一个死循环，用jvm自带的性能监控工具查找问题
 * 
 * @author zhangzhiwang
 * @date 2018年2月8日 下午1:07:09
 */
public class Test8 {
	public static void main(String[] args) {
		TestThread t = new TestThread();
		t.setName("第一个线程");
		t.start();
	}
	
	private static void met1() {
		while(true) {
			byte[] b = new byte[1];
		}
	}
	
	static class TestThread extends Thread {
		@Override
		public void run() {
			met1();
		}
	}
}
