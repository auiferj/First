package Chap18;

import java.awt.event.*;
import java.awt.*;
import java.rmi.*;
import javax.swing.*;

/**
 * 2013.04.19
 * Michel
 * 用户端
 */
public class ServiceBrowser {
	
	JPanel mainPanel;
	JComboBox serviceList;
	ServiceServer server;
	 
	public void buildGUI(){
		JFrame frame = new JFrame("RMT Browser");
		mainPanel = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		
		//此方法执行RMI registry查询，取得stub并调用getServicesList()
		Object[] services = getServicesList();
		
		//把此服务添加到JComboBox里面，JComboBox知道如何显示数组中的字符串
		serviceList = new JComboBox(services);
		
		frame.getContentPane().add(BorderLayout.NORTH, serviceList);
		
		serviceList.addActionListener(new MyListListener());
		
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	
	void loadService(Object serviceSelection){
		try{
			//把实际的服务添加到GUI的mainPanel中
			Service svc = server.getService(serviceSelection);
			
			mainPanel.removeAll();
			mainPanel.add(svc.getGuiPanel());
			mainPanel.validate();
			mainPanel.repaint();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	Object[] getServicesList(){
		Object obj = null;
		Object[] services = null;
		
		try{
			//执行RMI查询，取得stub
			//obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
			obj = Naming.lookup("rmi://127.0.0.1:4399/ServiceServer");
		} catch(Exception ex){
			ex.printStackTrace();
		}
		//将stub转换成remote interface的类型，如此才能调用它的getServiceList()
		server = (ServiceServer)obj;
		
		try{
			//它会返回Object的数组
			services = server.getServiceList();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		 
		return services;
	}
	
	class MyListListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			// TODO Auto-generated method stub
			Object selection = serviceList.getSelectedItem();
			//用户点击JComboBox的项目后会到这里来，
			//因此就会把相对应的服务加载
			loadService(selection);
		}
		
	}
	
	public static void main(String[] args){
		new ServiceBrowser().buildGUI();
	}
}
