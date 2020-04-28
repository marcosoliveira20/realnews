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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Noticias() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticiaService a = new NoticiaService();
		ArrayList<Noticia> lista = new ArrayList<>();
		PrintWriter out = response.getWriter();
		lista = a.buscarNoticias();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		out = response.getWriter();
		// out.println("<HTML><HEAD><TITLE>Hello World!</TITLE>" + "</HEAD><BODY>Hello
		for (int i = 0; i < lista.size(); i++) {
			out.println("<p>" + lista.get(i).getTitulo() + "</p>");
		}

		out.println("</body></html>");

		// World!</BODY></HTML>");
		//out.println("<html><head><title>Professor Cadastrado</title></head><body>");

		
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
