package br.edu.ifmt.cba.Model;

public class Departamento {
	private int id;
	private String nome;
	private Usuario usuario;

	public Departamento() {}

	public Departamento(String nome, Usuario usuario) {
		this.nome = nome;
		this.usuario = usuario;
	}

	public Departamento(int id, String nome, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
	}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public Usuario getUsuario() {return usuario;}

	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
