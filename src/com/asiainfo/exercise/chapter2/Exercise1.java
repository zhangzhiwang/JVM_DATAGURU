package com.asiainfo.exercise.chapter2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

/**
 * 第2章作业1：写一个程序，让程序在运行之后，最终抛出由于Perm区溢出引起的OOM，给出运行的jdk版本，程序源码，运行参数，以及系统溢出后的截图、程序所依赖的jar包说明，并说明你的基本思路
 * 
 * @author zhangzhiwang
 * @date 2018年1月30日 下午9:55:30
 */
public class Exercise1 {
	public static void main(String[] args) {
		/*
		 * 运行参数：-XX:PermSize=2M -XX:MaxPermSize=2M
		 * 思路：由于Perm区（方法区）保存着类的信息，那么就将大量的类型信息保存到里面同时将永久去的初始空间和最大空间调小，方法就是通过Cglib动态产生大量的代理类。
		 */
		int i = 0;
		try {
			for (i = 0; i < 1000000; i++) {
				HashMap<String, Object> propertyMap = new HashMap<>();
				propertyMap.put("id", Class.forName("java.lang.Integer"));
				propertyMap.put("name", Class.forName("java.lang.String"));
				propertyMap.put("address", Class.forName("java.lang.String"));

				new CglibBean(propertyMap);
			}
		} catch (Exception e) {
			System.out.println("总共创建：" + i);
			e.printStackTrace();
		}
	}
}

class CglibBean {
	/**
	 * 实体Object
	 */
	public Object object = null;

	/**
	 * 属性map
	 */
	public BeanMap beanMap = null;

	public CglibBean() {
		super();
	}

	@SuppressWarnings("unchecked")
	public CglibBean(Map propertyMap) {
		this.object = generateBean(propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}

	/**
	 * 给bean属性赋值
	 * 
	 * @param property
	 *            属性名
	 * @param value
	 *            值
	 */
	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	/**
	 * 通过属性名得到属性值
	 * 
	 * @param property
	 *            属性名
	 * @return 值
	 */
	public Object getValue(String property) {
		return beanMap.get(property);
	}

	/**
	 * 得到该实体bean对象
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}

	@SuppressWarnings("unchecked")
	private Object generateBean(Map propertyMap) {
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for (Iterator i = keySet.iterator(); i.hasNext();) {
			String key = (String) i.next();
			generator.addProperty(key, (Class) propertyMap.get(key));
		}
		return generator.create();
	}
}