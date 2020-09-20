package Chap18;

/**
 * 2013.04.18
 * Michel
 * Remote service(实现)
 */
import java.rmi.*;
import java.rmi.server.*;
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	public String sayHello(){
		return "Server says, 'Hey";
	}
	
	//父类的构造函数声明了异常，所以你必须写出构造函数，
	//因为它代表你的构造函数会调用有风险的程序代码
	public MyRemoteImpl() throws RemoteException{}
	
	public static void main(String[] args){
		try{
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("Remote hello", service);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
