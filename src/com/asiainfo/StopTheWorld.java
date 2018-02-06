package com.asiainfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证STW
 * 
 * @author zhangzhiwang
 * @date 2018年2月4日 下午3:10:33
 */
public class StopTheWorld {
	public static void main(String[] args) {
		//用以下参数来运行：-Xms512m -Xmx512m -Xmn1m -XX:+UseSerialGC -XX:+PrintGCDetails -Xloggc:/Users/zhangzhiwang/Desktop/system/log/gc_1.log  -XX:PretenureSizeThreshold=50 -XX:MaxTenuringThreshold=1
		new TimeThread().start();
		new MapThread().start();
	}
}

class TimeThread extends Thread {
	private static final long start = System.currentTimeMillis();

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("time:" + (System.currentTimeMillis() - start));
				Thread.sleep(100);// 每0.1s打印一次时间
			}
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}
}

class MapThread extends Thread {
	private Map<Long, byte[]> map = new HashMap<>();

	@Override
	public void run() {
		try {
			while (true) {
				if (map.size() * 512 / 1024 / 2014 >= 450) {
					System.out.println("准备清理map：" + map.size());
					map.clear();
				}

				for (int i = 0; i < 1024; i++) {
					map.put(System.nanoTime(), new byte[512]);
				}
				Thread.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}