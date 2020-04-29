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
		// TODO Auto-generated method stub
		String pTexto = request.getParameter("texto");
		String pTitulo = request.getParameter("titulo");
		String pDescricao = request.getParameter("descricao");

		// instanciar o javabean
		Noticia noticia = new Noticia();
		noticia.setTitulo(pTitulo);
		noticia.setDescricao(pDescricao);
		noticia.setTexto(pTexto);

		// instanciar o service
		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		noticia = cs.carregar(noticia.getId());
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"<h1>"+noticia.getTitulo()+"</h1><br>");
		out.println("<hr>");
		out.println(noticia.getTexto()+"<br>");
	    out.println("</body></html>");
	}

}
