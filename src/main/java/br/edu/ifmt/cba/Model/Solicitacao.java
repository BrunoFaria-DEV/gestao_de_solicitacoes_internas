package br.edu.ifmt.cba.Model;

public class Solicitacao {
	private int id;
	private String titulo;
	private String descricao;
	private String data_criacao;
	private String status;

	public Solicitacao() {}

	public Solicitacao(String titulo, String descricao, String data_criacao, String status) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_criacao = data_criacao;
		this.status = status;
	}

	public Solicitacao(int id, String titulo, String descricao, String data_criacao, String status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_criacao = data_criacao;
		this.status = status;
	}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getTitulo() {return titulo;}

	public void setTitulo(String titulo) {this.titulo = titulo;}

	public String getDescricao() {return descricao;}

	public void setDescricao(String descricao) {this.descricao = descricao;}

	public String getData_criacao() {return data_criacao;}

	public void setData_criacao(String data_criacao) {this.data_criacao = data_criacao;}

	public String getStatus() {return status;}

	public void setStatus(String status) {this.status = status;}
}
