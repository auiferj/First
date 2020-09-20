package Chap18;
 
/**
 * 2013.04.19
 * Michel
 * (远程接口)
 */
import java.rmi.*;
public interface ServiceServer extends Remote {
	//一般的RMI接口，定义出两个远程服务要实现的方法
	Object[] getServiceList() throws RemoteException;
	Service getService(Object serviceKey) throws RemoteException;
}
