package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class ManterNoticiaController
 */
@WebServlet("/ManterNoticia.do")
public class ManterNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterNoticiaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pTexto = request.getParameter("texto");
		String pTitulo = request.getParameter("titulo");
		String pDescricao = request.getParameter("descricao");

		Noticia noticia = new Noticia();
		noticia.setTitulo(pTitulo);
		noticia.setDescricao(pDescricao);
		noticia.setTexto(pTexto);

		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		noticia = cs.carregar(noticia.getId());
		response.sendRedirect("./Ler.do?id="+noticia.getId() );
	}

}
