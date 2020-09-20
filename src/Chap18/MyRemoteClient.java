package Chap18;

/**
 * 2013.04.8
 * Michel
 * 完整的客户端程序代码
 */
import java.rmi.*;
public class MyRemoteClient {
	public void go(){
		try{
			//MyRemote：客户端必须要使用与服务相同的类型，事实上 客户端不需要知道服务实际上的类名称
			//(MyRemote):必须转化成接口的类型,因为查询结果会是object类型
			//lookup()是个静态方法
			//127.0.0.1:主机名称或者ip地址
			//Remote Hello:必须要跟注册的名称一样
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
			
			String s = service.sayHello();
			
			System.out.println(s);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new MyRemoteClient().go();
	}
}
