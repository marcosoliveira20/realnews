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
                            		out.println(
                            				
                            			 "<div class='postagem'>"
	                                        +"<h2><a href='./Ler.do?id="+noticia.getId() +"'>" + noticia.getTitulo()+"</a></h2><br>"
	                                        +"<p>" +noticia.getDescricao() +"<a href='./Ler.do?id="+noticia.getId() +"'>" +"Ler mais..." +"</a></p>"
	                                        +"</div>"
                                        +"<br>");
                            	}
                            	
                            	out.println("</div>"
                                +"<br>"
                                +"		<div id=\"area-lateral\">\r\n" + 
                                "			<h3>Menu Lateral</h3>\r\n" + 
                                "			<div class=\"conteudo-lateral\">\r\n" + 
                                "				<h4>Vejá o que pode fazer</h4>\r\n" + 
                                "				<br><p><a href='./CriarNoticias.do'>Crie Sua Noticia.</a>\r\n" + 
                                "					do</p>\r\n" + 
                                "\r\n" + 
                                "			</div>\r\n" + 
                                "		<br>\r\n" + 
                                "			<div class=\"conteudo-lateral\">\r\n" + 
                                "			<h4>Lista de noticias</h4>\r\n" );
                            	Noticia noticia =new Noticia();
                            	ArrayList <Noticia> b = new ArrayList<Noticia>();
                            	b = a.buscarNoticias();
                            	for (int i=b.size() -1; i>b.size()-3; i--) {
                            		noticia = b.get(i);
                            		if (noticia.getTitulo().length()> 30){
                            		out.println("<a href='./Ler.do?id="+noticia.getId() +"'>" + noticia.getTitulo().substring(0, noticia.getTitulo().length()-20)+"</a><br><br>");
                            	}
                            		else {
                            			out.println("<a href='./Ler.do?id="+noticia.getId() +"'>" + noticia.getTitulo()+"</a><br>");
                                    	}
                            		}
                            	
                                out.println(
                                "			</div>\r\n" + 
                                "\r\n" + 
                                "\r\n" + 
                                "		</div>"
                                
                
                              
                );
		

		response.getWriter().append("</body></html>");


		out.close();
	}
}
