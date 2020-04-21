package service;

import model.Noticia;
import dao.NoticiaDAO;


public class NoticiaService {
	NoticiaDAO dao = new NoticiaDAO();
	
	public int criar(Noticia noticia) {
		return dao.criar(noticia);
	}
	
	public void atualizar(Noticia noticia){
		dao.atualizar(noticia);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Noticia carregar(int id){
		return dao.carregar(id);
	}

}
