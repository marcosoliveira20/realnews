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
		response.getWriter().append("Served ssssss: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.getWriter().append("<p>" + "  AAAAAA");
		for (int i = 0; i < lista.size(); i++) {
			response.getWriter().append("<p>" + "  ddd dd" + lista.get(i).getTitulo() + "</p>");
		}
		response.getWriter().append("</body></html>");
		// World!</BODY></HTML>");
		// out.println("<html><head><title>Professor Cadastrado</title></head><body>");

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
