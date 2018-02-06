package com.asiainfo;

/**
 * 测试根类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年2月5日 下午4:18:16
 */
public class TestBootStrapClassLoader {
	public static void main(String[] args) {
		//根类加载器默认加载rt.jar里面的class
		//如果要让根类加载器在指定目录加载class文件可用参数：-Xbootclasspath/a:被加载class的路径。比如要让bootStrap在当前路径加载class：java -Xbootclasspath/a:. TestBootStrapClassLoader    此时TestBootStrapClassLoader将由根类加载器加载
		//详情可参考：http://blog.csdn.net/gyflyx/article/details/8764889
		
		//扩展类加载器默认在%JAVA_HOME%/jre/lib/ext目录下加载，注：要让扩展类加载器加载某 class文件，需要将该 class文件放到jar中并将该jar放到%JAVA_HOME%/jre/lib/ext下，必须放到jar中，无法直接读取class文件
		System.out.println(TestBootStrapClassLoader.class.getClassLoader());
	}
}
