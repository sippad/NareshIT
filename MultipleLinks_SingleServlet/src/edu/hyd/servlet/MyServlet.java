package edu.hyd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param=null;
		PrintWriter pw=null;
		Locale locale[]=null;			
		
		response.setContentType("text/html");
		pw=response.getWriter();
		param = request.getParameter("p");
		
		if(param.equals("countries")){
			locale= Locale.getAvailableLocales();
			for(Locale l : locale){
				pw.println(l.getDisplayCountry()+"<br>");
			}
		}
		else if(param.equals("lang")){
			
		}
		else if(param.equals("sysdate")){
			
		}								
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
