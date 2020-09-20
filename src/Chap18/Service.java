package Chap18;
 
/**
 * 2013.04.19
 * Michel
 * GUI服务要实现的部分
 */
import javax.swing.*;
import java.io.*;
public interface Service extends Serializable {
	//定义任何通用服务都得要实现的getGuiPanel()这个方法
	//，因为继承Serializable,所以能够自动地序列化
	//，而这也是又通过网络传送服务所必需的机制
	public JPanel getGuiPanel();
}
