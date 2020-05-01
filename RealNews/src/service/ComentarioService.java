package service;

import model.Comentario;
import model.Noticia;

import java.util.ArrayList;

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
	/**
	 * @param 
	 * @return ArrayList<Comentario>
	 */
	public ArrayList<Comentario> listar(int id) {
		try {
			return dao.buscarComentario(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void apagarComentarios(int fkid){
		dao.apagarComentarios(fkid);
	}
	
}
