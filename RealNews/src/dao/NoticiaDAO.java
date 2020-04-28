package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

public class NoticiaDAO {
	public int criar(Noticia noticia) {
		String sqlInsert = "INSERT INTO noticia(descricao, titulo, texto) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTexto());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					noticia.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticia.getId();
	}

	public void atualizar(Noticia noticia) {
		String sqlUpdate = "UPDATE noticia SET descricao=?, titulo=?, texto=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTexto());
			stm.setInt(4, noticia.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM noticia WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Noticia carregar(int id) {
		Noticia noticia = new Noticia();
		noticia.setId(id);
		String sqlSelect = "SELECT descricao, titulo, texto FROM noticia WHERE noticia.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, noticia.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					noticia.setDescricao(rs.getString("descricao"));
					noticia.setTitulo(rs.getString("titulo"));
					noticia.setTexto(rs.getString("texto"));
				} else {
					noticia.setId(-1);
					noticia.setDescricao(null);
					noticia.setTitulo(null);
					noticia.setTexto(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}
	
	public ArrayList <Noticia> buscarNoticias() {
		ArrayList <Noticia> lista = new ArrayList<>();
		Noticia noticia = null;
		String sqlSelect = "SELECT id, descricao, titulo, texto from noticia";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next())
					noticia = new Noticia();
					if (rs.next()) {
						noticia.setId(Integer.parseInt(rs.getString("id")));
						noticia.setDescricao(rs.getString("descricao"));
						noticia.setTitulo(rs.getString("titulo"));
						noticia.setTexto(rs.getString("texto"));
						lista.add(noticia);
					} else {
						noticia.setId(-1);
						noticia.setDescricao(null);
						noticia.setTitulo(null);
						noticia.setTexto(null);
					}
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return lista;
	}


}
