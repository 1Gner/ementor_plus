package model;

public class Usuario  {
	private String NomeUsuario;
	private String Senha;
	private Integer NivelAcesso;




	public Usuario(String nomeUsuario, String senha, Integer nivelAcesso) {
		super();
		NomeUsuario = nomeUsuario;
		Senha = senha;
		NivelAcesso = nivelAcesso;
	}


	public Usuario() {
		super();
	}


	public String getNomeUsuario() {
		return NomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		NomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Integer getNivelAcesso() {
		return NivelAcesso;
	}
	public void setNivelAcesso(Integer nivelAcesso) {
		NivelAcesso = nivelAcesso;
	}



}
