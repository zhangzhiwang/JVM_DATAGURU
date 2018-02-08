package com.asiainfo;

/**
 * 模拟线程死锁，用jvm自带的性能监控工具查找问题
 * 
 * @author zhangzhiwang
 * @date 2018年2月8日 下午1:30:04
 */
public class DeadLock {
	private static Object o1 = new Object();
	private static Object o2 = new Object();

	static class TestThread1 extends Thread {
		private String name;

		public TestThread1() {
			super();
		}

		public TestThread1(String name) {
			super();
			this.name = name;
		}

		@Override
		public void run() {
			synchronized (o1) {
				try {
					System.out.println(Thread.currentThread().getName() + "locked o1.");
					Thread.sleep(1000);
					synchronized (o2) {
						try {
							System.out.println(Thread.currentThread().getName() + "locked o2.");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	static class TestThread2 extends Thread {
		private String name;

		public TestThread2() {
			super();
		}

		public TestThread2(String name) {
			super();
			this.name = name;
		}

		@Override
		public void run() {
			synchronized (o2) {
				try {
					System.out.println(Thread.currentThread().getName() + "locked o2.");
					Thread.sleep(1000);
					synchronized (o1) {
						try {
							System.out.println(Thread.currentThread().getName() + "locked o1.");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public static void main(String[] args) {
		TestThread1 t1 = new TestThread1();
		t1.setName("第一个线程");
		t1.start();
		
		TestThread2 t2 = new TestThread2();
		t2.setName("第二个线程");
		t2.start();
	}
}
