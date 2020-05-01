package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

/**
 * Servlet implementation class NoticiaFull
 */
@WebServlet("/Ler.do")
public class Ler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		 
		PrintWriter out = response.getWriter();
		NoticiaService ns = new NoticiaService();
		Noticia noticia = ns.carregar(id);
		
		
		ComentarioService cs = new ComentarioService();
	 
      response.setIntHeader("Refresh", 60);

      response.setContentType("text/html");

		out.println(
				"<html>"
						+"<head>"
							+"<meta charset='utf-8'>"
							+"<title>RealNews: "+noticia.getTitulo()+"</title>"	
							+"<link rel='stylesheet' type='text/css' href='CSS/estilos.css'>"		
						+"</head>"
						+"<body>"
							+"<div id='area-cabecalho'>"
								+"<div id='area-logo'>"
									+"<h1>"
										+"<a href='./Noticias.do'>RealNews</a></h1>"
									+"</h1>"
								+"</div>"
							+"</div>"

							+"<hr>"
							
							+"<div class='divNoticia'>"
								+"<h3>"+noticia.getTitulo()+"</h3>"
								+"<p>"+noticia.getDescricao()+"</p>"
								+"<p>"+noticia.getTexto()+"</p>"
							+"</div>"
							
							+"<hr>"
							
							+"<h3>Comentarios</h3>"
				);
						for (Comentario comentario : cs.listar(id)) {
							out.print(
									"<div>"
										+ "<h4>" +comentario.getNome() + "</h4>"
										+ "<p>" +comentario.getTexto() + "</p>"
									+ "</div>"
							);
						}
		out.println(
						"<hr>"
							
						+"<h3 >Escreva seu comentário</h3>"
						
						+"<form  action='./EscreverComentario.do' method='post'>"
			
							+"<input type='hidden' value='"+id+"' name='idNoticia'>"
										+ "<table>"
						
							+ "<tr>"
								+"<td><label>Nome: </label></td>"
								+"<td><input name='nome' type='text' placeholder='Digite seu nome!'></td>"
							+ "</tr>"
							+ "<tr>"	
							+"<td>"
								+ "<label>Comentario: </label><"
							+ "/td>"
							+"<td>"
								+"<textarea name='comentario' rows='5' placeholder='Escreva seu comentário'></textarea>"
							+"</td>"
							+ "</table>"
							+"<input  type=submit >"
						+"</form>"
						+ "<table>"	
						+ "<tr>"
						+ "<td>"
							+"<form action='./ExecutaMudanca.do' method='post'>"
								+"<input type='hidden' value='"+id+"' name='idNoticia'>"
								+"<button type=submit >"
									+"Editar"
								+"</button>"
							+"</form>"
							+ "</td>"
							+ "<td>"
							+"<form action='./Apagar.do' method='post'>"
								+"<input type='hidden' value='"+id+"' name='idNoticia'>"
								+"<button type=submit>"
									+"Excluir"
								+"</button>"
							+"</form>"
							+ "</td>"
							+ "<tr>"
						+ "</table>"
					+"</body>"
				+"</html>"
				);
		
	}
}