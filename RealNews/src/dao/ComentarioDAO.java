package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;
import model.Noticia;
import service.NoticiaService;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario(nome, texto, fk_noticia_id) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getFkNoticiaId());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getId();
	}

	public void atualizar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET nome=?, texto=?, fk_noticia_id=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getFkNoticiaId());
			stm.setInt(4, comentario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM comentario WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Comentario carregar(int id) {
		Comentario comentario = new Comentario();
		comentario.setId(id);
		String sqlSelect = "SELECT nome, texto, fk_noticia_id FROM noticia WHERE comentario.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, comentario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comentario.setNome(rs.getString("nome"));
					comentario.setTexto(rs.getString("texto"));
					comentario.setFkNoticiaId(rs.getInt("fk_noticia_id"));
				} else {
					comentario.setId(-1);
					comentario.setNome(null);
					comentario.setTexto(null);
					comentario.setFkNoticiaId(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comentario;
	}
	/**
	 * Listar Comentarios
	 * @return ArrayList<Comentario> lista
	 * @throws Exception
	 */

	public ArrayList<Comentario> buscarComentario(int id) throws Exception {
		ArrayList<Comentario> lista = new ArrayList<>();
		String select = "SELECT * FROM comentario WHERE fk_noticia_id ="+id+" order by id desc";
		
		Connection conectar = ConnectionFactory.obtemConexao();
		PreparedStatement pst = conectar.prepareStatement(select);
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			Comentario comentario = new Comentario();
			NoticiaService noticia = new NoticiaService();
			comentario.setId(resultado.getInt("id"));
			comentario.setNome(resultado.getString("nome"));
			comentario.setTexto(resultado.getString("texto"));
			comentario.setNoticia(noticia.carregar(resultado.getInt("fk_noticia_id")));
			
			lista.add(comentario);
		}
			return lista;
		}
		
		
	
	public void apagarComentarios(int fkid) {
		String deletar = "DELETE FROM comentario WHERE fk_noticia_id = ?";
			
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			pst.setInt(1, fkid);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
