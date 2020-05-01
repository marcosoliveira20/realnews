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
@WebServlet("/Noticias.do")
public class Noticias extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		NoticiaService a = new NoticiaService();
		ArrayList<Noticia> lista = new ArrayList<>();
		PrintWriter out = response.getWriter();
		lista = a.buscarNoticias();
		response.setContentType("text/html");

			out.println(
                    "<html>"
                        +"<head>"
                            +"<meta charset='utf-8'>"
                            +"<title>RealNews</title>"
                            +"<link rel='stylesheet' type='text/css' href='CSS/estilos.css'>"
                        +"</head>"
                        +"<body>"
                            +"<div id='area-cabecalho'>"
                                +"<div id='area-logo'>"
                                    +"<h1>"
                                        +"Real<span class='branco'>News</span>"
                                    +"</h1>"
                                +"</div>"
                                +"</div>"
                            +"<div id='area-principal'>"
                                +"<div id='area-postagens'>");
                            	for (Noticia noticia : a.buscarNoticias()) {
                            		out.println("</div>" + "<div class='postagem'>"
                                        +"<h2><a href='./Ler.do?id="+noticia.getId() +"'>" + noticia.getTitulo()+"</a></h2><br>"
                                        +"<p>" +noticia.getDescricao() +"</p>"
                                        +"</div>"
                                        +"<br>");
                            	}
                            	
                            	out.println("</div>"
                                +"<br>"
                                +"<a href=''></a>"
                                
                
                              
                );
		
		out.println("" +

				"			<form action=\"ManterNoticia.do\" method=\"get\">\r\n"
				+ "<table>"
				+ "			<tr>	"
				+ "					<td>Titulo:</td><td><input type='text' name=\"titulo\"  placeholder=\"Escreva o título para notícia\"> </td> \r\n"
				+			"</tr>"			
				+ "			<tr>	"
				+ "				<td>Descrição:</td> <td><textarea rows='6' name=\"descricao\" placeholder=\"Escreva uma breve descrição da notícia\"></textarea></td>\r\n"
				+ "			</tr>	"
				+ "			<tr>	"
				+ "				<td>Texto:</td> <td><textarea  placeholder=\"Escreva a notícia\" rows='10' name=\"texto\"></textarea></td>\r\n"
			
				+ "			</tr>	"
				+ "</table>"
				+ "<input type=\"submit\">\r\n" + "		</form>"
				+               "<div id='rodape'>Todos os Direitos reservados!</div>");

		response.getWriter().append("</body></html>");


		out.close();
	}
}
