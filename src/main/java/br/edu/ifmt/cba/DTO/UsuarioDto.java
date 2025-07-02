package br.edu.ifmt.cba.DTO;

import org.apache.struts.action.ActionForm;

public class UsuarioDto extends ActionForm{
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String perfil;

	public UsuarioDto() {}

	public UsuarioDto(String nome,	String email, String senha, String perfil) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}

	public UsuarioDto(int id, String nome,	String email, String senha, String perfil) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
	}

	public int getId() {return id;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	public String getPerfil() {return perfil;}
	public void setPerfil(String perfil) {this.perfil = perfil;}
}
