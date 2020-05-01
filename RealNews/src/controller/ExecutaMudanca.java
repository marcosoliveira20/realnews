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
 * Servlet implementation class Comentario
 */
@WebServlet("/ExecutaMudanca.do")
public class ExecutaMudanca extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  id = Integer.parseInt(request.getParameter("idNoticia"));
		System.out.println(id+1);
		PrintWriter out = response.getWriter();
		NoticiaService ns = new NoticiaService();
		Noticia noticia = ns.carregar(id);
		
		response.setContentType("text/html");
		
		out.println("<html>"
                +"<head>"
                +"<meta charset='utf-8'>"
                +"<title>RealNews: editar "+noticia.getTitulo()+"</title>"
                +"<link rel='stylesheet' type='text/css' href='CSS/estilos.css'>"
            +"</head>"
            +"<body>"

                +"<div id='area-cabecalho'>"
                        +"<div id='area-logo'>"
                            +"<h1>"
                                +"<a href='./Noticias.do'> Real<span class='branco'>News</span></a>"
                            +"</h1>"
                        +"</div>"
                    +"</div>"
                +"<hr>"
                +"<h3>Editar noticia</h3>"
                +"<form class='formEdit' action='./ProcessaCriacao.do' method='post'>"
                    +"<input type='hidden' value='"+id+"' name='idNoticia'><br>"
                    +"<label>Titutlo</label><br><input type='text' value='"+noticia.getTitulo()+"' name='titulo'><br>"
                    +"<label>Descrição</label><br><textarea cols='130' rows='5' name='descricao'>"+noticia.getDescricao()+"</textarea><br>"
                    +"<label>Texto</label><br><textarea cols='130' rows='13' name='texto'>"+noticia.getTexto()+"</textarea><br>"
                    +"<button type=submit>"
                        +"Editar"
                    +"</button>"
                +"</form>"
            +"</body>"
        +"</html>"
				);
		
	}
}
