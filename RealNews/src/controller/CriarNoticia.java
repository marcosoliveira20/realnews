package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;

/**
 * Servlet implementation class CriarNoticia
 */
@WebServlet("/CriarNoticias.do")
public class CriarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");


	out.println(
			"                    <html>" + 
			"                        <head> "+ 
			"                            +\"<meta charset='utf-8'>" + 
			"									<title>RealNews</title>" + 
			"                            <link rel='stylesheet' type='text/css' href='CSS/estilos.css'>" + 
			"                        </head> "+ 
			"                        <body> "
			+ "										<div id='area-cabecalho'>" + 
			"										<div id='area-logo'>" + 
			"											<h1>"+ 
			"												<a href='./Noticias.do'>RealNews</a></h1>" + 
			"											</h1>" + 
			"										</div>" + 
			"									</div>" + 
			"<div id='area-principal'>"
            +"<div id='area-postagens'>"
        	
			+"			<form action=\"ManterNoticia.do\" method=\"get\">"
			+ "					<input cols='100'type='text' name=\"titulo\"  placeholder=\"Escreva o título para notícia\">"
			+			""			
			+ "	<br>"
			+ "				<textarea cols='130' rows='5' name=\"descricao\" placeholder='Escreva uma breve descrição da notícia'> </textarea>"
			+ "				"
			+ "	<br>"
			+ "				<textarea cols='130' rows='25 name=\"texto\" placeholder= 'Escreva a sua notícia'></textarea>"
			
			+ "<input type=\"submit\"> </form>"
			+"</div>"
			+"</div>"
			+               "<div id='rodape'>Todos os Direitos reservados!</div>");

	response.getWriter().append("</body></html>");


	out.close();
	}
}
