package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;
import model.Noticia;

/**
 * Servlet implementation class Noticias
 */
@WebServlet("/Noticias")
public class Noticias extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
	// TODO Auto-generated method stub
		NoticiaService a = new NoticiaService();
		ArrayList<Noticia> lista = new ArrayList<>();
		PrintWriter out = response.getWriter();
		lista = a.buscarNoticias();
		//response.getWriter().append("Served ssssss: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.getWriter().append("<head>");
		
		response.getWriter().append("<meta charset=" + "utf-8>");
	
		response.getWriter().append("<body>");
		response.getWriter().append("\r\n" + 
				"<style>\r\n" + 
				"table, th, td {\r\n" + 
				"  border: 1px solid black;\r\n" + 
				"}\r\n" + 
				"</style>");
		response.getWriter().append("</head>");
		
		response.getWriter().append("<body>");
				
		
		// cada noticia recebe propriedades como botao, link e descricao
		for (Noticia noticia : a.buscarNoticias()) {
			out.print(
					"<button>"
						+ "<a href='./Leitura.do?id=" +noticia.getId() +"'>" + noticia.getTitulo() +"</a>"
						+ "<p>" +noticia.getDescricao() +"</p>"
					+ "</button>"
			);
		}

		response.getWriter().append("<hr>");
		response.getWriter().append(""+
				
				"			<form action=\"ManterNoticia.do\" method=\"get\">\r\n" + 
				"				Titulo: <input type=\"text\" name=\"titulo\"><br>\r\n" + 
				"				Descrição: <input type=\"text\" name=\"descricao\"><br>\r\n" + 
				"				Texto: <input type=\"text\" name=\"texto\"><br>\r\n" + 
				"			<input type=\"submit\">\r\n" + 
				"		</form>");
		
		response.getWriter().append("</body></html>");
		// World!</BODY></HTML>");
		// out.println("<html><head><title>Professor Cadastrado</title></head><body>");

		out.close();
	}
}
