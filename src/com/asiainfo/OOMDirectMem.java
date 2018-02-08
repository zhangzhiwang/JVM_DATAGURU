package com.asiainfo;

import java.nio.ByteBuffer;

/**
 * OOM——直接内存溢出
 * 
 * @author zhangzhiwang
 * @date 2018年2月8日 下午3:47:57
 */
public class OOMDirectMem {
	public static void main(String[] args) {
		//模拟OOM第四种情况——直接内存溢出
		//NIO会使用到直接内存，使用参数-XX:MaxDirectMemorySize=100m测试
		for(int i = 0; i < 2014; i++) {
			ByteBuffer.allocateDirect(1024 * 1024 * 1024);
		}
	}
}
