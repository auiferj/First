package Chap18;

/**
 * 2013.04.18
 * Michel
 */
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Chap01.PhraseOMatic;
public class KathyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException ,IOException {
	
		String title = "PhraseOMatic has generated the following phrase.";
		
		//告诉服务器和浏览器相应结果的形式
		response.setContentType("text/html");
		
		//此对象会给我们可写回结果的输出串流
		PrintWriter out = response.getWriter();
		
		String message = "If you're reading this ,it worked1";
		
		//我们的print对象是个网页
		out.println("<HTML><BODY><TITLE>");
		out.println("PhraseOmatic");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>" + title + "</H1>");
		out.println("<P>" + Chap18.PhraseOMatic.makePhrase());
		out.println("<P><a href=\"KathyServlet\">make another phrase</a></p>");
		out.println("</BODY></HTML>");
		out.close();
	}
}