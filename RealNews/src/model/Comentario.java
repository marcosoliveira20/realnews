package model;

import java.io.Serializable;

public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String texto;
	private int fkNoticiaId;

	public Comentario() {
	}

	public Comentario(int id, String nome, String texto, int fkNoticiaId) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
		this.fkNoticiaId = fkNoticiaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getFkNoticiaId() {
		return fkNoticiaId;
	}

	public void setFkNoticiaId(int fkNoticiaId) {
		this.fkNoticiaId = fkNoticiaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", nome=" + nome + ", texto=" + texto + ", fkNoticiaId=" + fkNoticiaId + "]";
	}
	

}
