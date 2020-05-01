package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ComentarioService;
import service.NoticiaService;


/**
 * Servlet implementation class Comentario
 */
@WebServlet("/Apagar.do")
public class Apagar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apagar() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComentarioService cs = new ComentarioService();
		NoticiaService ns = new NoticiaService();
		
		
		String a = request.getParameter("idNoticia");
		int idNoticia = Integer.parseInt(a);
		
		
		cs.apagarComentarios(idNoticia);
		ns.excluir(idNoticia);
		
		
		response.sendRedirect("./Noticias.do");
	}
}