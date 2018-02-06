package com.asiainfo;

/**
 * 复活对象
 * 
 * @author zhangzhiwang
 * @date 2018年2月4日 下午2:40:01
 */
public class Relive {
	private static Relive relive;

	public static void main(String[] args) throws InterruptedException {
		relive = new Relive();
		System.out.println("relive 1st:" + relive);
		relive = null;
		System.gc();
		Thread.sleep(10);
		System.out.println(relive == null);
		System.out.println("relive 2nd:" + relive);
		System.out.println("--------------------");
		relive = null;
		System.gc();
		System.out.println(relive == null);
	}

	@Override
	public void finalize() {
		relive = this;
	}
}
