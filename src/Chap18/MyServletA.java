package Chap18;


/**
 * 2013.04.18
 * Michel
 * 很简单的servlet
 * 记住servlet.jar是需要另外下载的，因为它不是java标准库的一部分
 * 必须要有支持servlet的web服务器才能运行servlet，比如Tomcat
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServletA extends HttpServlet {
	//一般的servlet会继承HttpServlet
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException {
		
		//告诉服务器和浏览器相应结果的形式
		response.setContentType("text/html");
		
		//此对象会给我们可写回结果的输出串流
		PrintWriter out = response.getWriter();
		
		String message = "If you're reading this ,it worked1";
		
		//我们的print对象是个网页
		out.println("<HTML><BODY>");
		out.println("<H1>" + message + "</H1>");
		out.println("</BODY></HTML>");
		out.close();
	}
}

//连接到servlet的html网页
/*
<HTML>
  <BODY>
    <a href="servlets/MyServletA">This is an amazing servlet.</a>
  </BODY>
</HTML>
 */
