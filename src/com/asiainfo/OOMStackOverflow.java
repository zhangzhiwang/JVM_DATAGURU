package com.asiainfo;

/**
 * OOM——栈溢出
 * 
 * @author zhangzhiwang
 * @date 2018年2月8日 下午3:35:10
 */
public class OOMStackOverflow {
	private static int num;

	public static void main(String[] args) {
		//模拟OOM第三种情况——java栈溢出
		deepLoop((byte) 0, (short) 0, 0, 0, 0.0f, 0.0, true, 'a');
	}

	private static void deepLoop(byte b, short s, int i, long l, float f, double d, boolean boo, char c) {
		byte b1 = 0;
		short s1 = 0;
		int i1 = 0;
		long l1 = 0;
		float f1 = 0.0f;
		double d1 = 0.0;
		char c1 = 'a';
		boolean boo1 = true;
		num++;
		if (num == Integer.MAX_VALUE) {
			return;
		}
		deepLoop(b1, s1, i1, l1, f1, d1, boo1, c1);
	}
}
