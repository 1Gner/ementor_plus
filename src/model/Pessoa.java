package model;

public class Pessoa {
	protected String Nome;
	protected String DataNascimento;
	protected Long CPF;
	protected String Telefone;
	protected String Rua;
	protected String Bairro;
	protected String Cidade;
	protected String Estado;




	public Pessoa(String nome, String dataNascimento, Long cPF, String telefone, String rua, String bairro,
			String cidade, String estado) {
		super();
		Nome = nome;
		DataNascimento = dataNascimento;
		CPF = cPF;
		Telefone = telefone;
		Rua = rua;
		Bairro = bairro;
		Cidade = cidade;
		Estado = estado;
	}




	public Pessoa() {
		super();
	}




	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getRua() {
		return Rua;
	}
	public void setRua(String rua) {
		Rua = rua;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}



}
