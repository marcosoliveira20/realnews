package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ComentarioService;
import service.NoticiaService;
import model.Comentario;
import model.Noticia;

/**
 * Servlet implementation class Comentario
 */
@WebServlet("/EscreverComentario.do")
public class EscreverComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscreverComentario() {
        super();
 
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComentarioService cs = new ComentarioService();
		Comentario comentario = new Comentario();
		
		NoticiaService ns = new NoticiaService();
		Noticia noticia = new Noticia();
		String a = request.getParameter("idNoticia");
		int idNoticia = Integer.parseInt(a);
		noticia = ns.carregar(idNoticia);
		System.out.println(idNoticia+" "+(idNoticia+1) );
		
		comentario.setNome(request.getParameter("nome"));
		comentario.setTexto(request.getParameter("comentario"));
		comentario.setNoticia(noticia);
		comentario.setFkNoticiaId(idNoticia);
		
		cs.criar(comentario);
		
		response.sendRedirect("./Ler.do?id="+idNoticia);
		
	}

}
