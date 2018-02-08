package com.asiainfo;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM——堆溢出
 * 
 * @author zhangzhiwang
 * @date 2018年2月8日 下午3:10:44
 */
public class OOMHeapSpace {
	public static void main(String[] args) {
		//模拟OOM第一种情况——堆溢出
		//用参数-Xms10m -Xmx50m测试
		List<byte[]> list = new ArrayList<>();
		for(int i = 0; i < 1000; i++) {
			list.add(new byte[10 * 1024 * 1024]);
		}
	}
}
