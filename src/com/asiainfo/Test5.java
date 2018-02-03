package com.asiainfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试导出dump日志
 * 
 * @author zhangzhiwang
 * @date 2018年2月3日 下午8:21:38
 */
public class Test5 {
	public static void main(String[] args) {
		// 模拟OOM，当发生OOM时导出dump日志
		List<byte[]> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add(new byte[1 * 2014 * 1024]);
		}
	}
}
