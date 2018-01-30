package com.asiainfo.exercise.chapter2;

/**
 * 第2章作业2:你能想到有什么办法，可以让一个程序的函数调用层次变的更深。比如，你在一个递归调用中，发生了stack的溢出，你可以做哪些方面的尝试，使系统尽量不溢出？阐述你的观点和原因。
 * 
 * @author zhangzhiwang
 * @date 2018年1月30日 下午10:44:06
 */
public class Exercise2 {
	private static int count;

	public static void main(String[] args) {
		/*
		 * 增加递归的调用深度有两个方法：第一个就是加大java栈的空间，即增加-Xss的值；第二个就是减少方法的局部变量包括参数的个数。因为当一个方法被调用的时候会有一个栈桢压入Java栈，而栈桢的主要部分是局部变量表，递归方法每调用一次就会有一个栈桢被压入Java栈，当Java栈的大小固定的时候，局部变量表越大栈桢就越大，那么能调用的次数就变少
		 */
		try {
//			deepLoop();
			 deepLoop((byte) 1, (short) 1, 1, 1, 0.0f, 0.0, true, 'a');
		} catch (Throwable e) {
			System.out.println(count);
			e.printStackTrace();
		}
	}

	private static void deepLoop() {
		count++;
		deepLoop();
	}

	private static void deepLoop(byte b, short s, int i, long l, float f, double d, boolean boo, char c) {
//		byte b1 = 0;
//		short s1 = 0;
//		int i1 = 0;
//		long l1 = 0;
//		char c1 = '0';
//		boolean boo1 = true;
//		float f1 = 0.0f;
//		double d1 = 0.0;

		count++;
		deepLoop((byte) 1, (short) 1, 1, 1, 0.0f, 0.0, true, 'a');
	}
}
