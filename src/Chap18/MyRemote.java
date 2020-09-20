package Chap18;

/**
 * 2013.04.18
 * Michel
 * Remote interface
 */
import java.rmi.*;
public interface MyRemote extends Remote {
	//每个远程调用都会被认为是有风险的，throws RemoteException
	//远程方法的参数和返回这必须是primitive或Serializable的。
	public String sayHello() throws RemoteException;
}
