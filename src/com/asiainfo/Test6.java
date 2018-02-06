package com.asiainfo;

/**
 * 模拟栈溢出（-Xss）
 * 
 * @author zhangzhiwang
 * @date 2018年2月3日 下午9:43:57
 */
public class Test6 {
	private static int count;
	
	public static void main(String[] args) {
		//总结：-Xms 初始堆内存，-Xmx 最大堆内存;-Xmn 新生代空间；-Xss Java栈空间
		try {
			deepLoop((byte) 0, (short) 0, 0, 0, 0.0f, 0.0, true, 'a');
		} catch (Throwable e) {
			System.out.println("count = " + count);
			e.printStackTrace();
		}
	}

	private static void deepLoop(byte b, short s, int i, long l, float f, double d, boolean boo, char c) {
		byte b1 = 0;
		short s1 = 0;
		int i1 = 0;
		long l1 = 0;
		float f1 = 0.0f;
		double d1 = 0.0;
		boolean boo1 = true;
		char c1 = 'a';

		count++;
		deepLoop(b1, s1, i1, l1, f1, d1, boo1, c1);
	}
}
