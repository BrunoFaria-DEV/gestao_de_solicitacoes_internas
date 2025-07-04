package br.edu.ifmt.cba.DTO;

import org.apache.struts.action.ActionForm;

public class LoginDto extends ActionForm{
	private String email;
	private String senha;

	public LoginDto() {}

	public LoginDto(String nome,	String email, String senha, String perfil) {
		this.email = email;
		this.senha = senha;
	}

	public LoginDto(int id, String nome,	String email, String senha, String perfil) {
		this.email = email;
		this.senha = senha;
	}

	public LoginDto(int id, String nome,	String email, String perfil) {
		this.email = email;
	}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
}
