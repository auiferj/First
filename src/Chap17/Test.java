package Chap17;

/**
 * 2013.04.18
 * Michel
 * 一些JAR包的打包和使用方法
 */
public class Test {
	
	//假设MyApp.java文件
	/*
	public class MyApp.jva {
		public static  void main(String[] args){ 
			 System.out.println("Hello World"); 
		}
	}
	*/
	//编译生成MyApp.class文件

	//manifest.txt文件内容：
	/*
	Main-Class: MyApp   
	 */
	//此行MyApp后面要有换行，否则可能出错。
	//注意MyApp前有个空格,MyApp后面不带.class，
	
	//执行jar工具来创建JAR文件
	//cmd命令：
	/*
	jar -cvmf manifest.txt app1.jar *.class
	*/
	//或者：
	/*
	jar -cvmf manifest.txt app1.jar MyApp.class
	*/
	//这样app1.jar文件就生成了
	
	//执行JAR文件
	//命令：
	/*
	java -jar app1.jar
	 */
	
	//注：如果路径不一样要记得带上文件名全路径。 
	
	
}
