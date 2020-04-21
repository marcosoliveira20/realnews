package service;

import model.Comentario;
import dao.ComentarioDAO;


public class ComentarioService {
	ComentarioDAO dao = new ComentarioDAO();
	
	public int criar(Comentario comentario) {
		return dao.criar(comentario);
	}
	
	public void atualizar(Comentario comentario){
		dao.atualizar(comentario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Comentario carregar(int id){
		return dao.carregar(id);
	}

}
