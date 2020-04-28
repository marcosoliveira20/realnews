package controller;


import javax.servlet.http.*;
 import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
@WebServlet("/Nos")
 public class HelloClientServlet extends HttpServlet
 {
   /**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req,
     HttpServletResponse res)
   throws ServletException, IOException
   {
     res.setContentType("text/html");
     PrintWriter out = res.getWriter();
     out.println("<HTML><HEAD><TITLE>Hello World!</TITLE>"+
     "</HEAD><BODY>Hello World!</BODY></HTML>");
     out.close();
   }

   public String getServletInfo()
   {
    return "Your first Hello Servlet!";
  }
 }