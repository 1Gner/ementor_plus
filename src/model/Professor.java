package model;

public class Professor extends Pessoa{
	private String DataAdmissao;
	private String cargoChefe;
	private String cargoCordenacao;
	private Double SalarioBase;





	public Professor(String nome, String dataNascimento, Long cPF, String telefone, String rua, String bairro,
			String cidade, String estado, String dataAdmissao, String cargoChefe, String cargoCordenacao,
			Double salarioBase) {
		super(nome, dataNascimento, cPF, telefone, rua, bairro, cidade, estado);
		DataAdmissao = dataAdmissao;
		this.cargoChefe = cargoChefe;
		this.cargoCordenacao = cargoCordenacao;
		SalarioBase = salarioBase;
	}




	public Professor() {
		super();
	}




	public Double getSalarioBase() {
		return SalarioBase;
	}




	public void setSalarioBase(Double salarioBase) {
		SalarioBase = salarioBase;
	}




	public String getDataAdmissao() {
		return DataAdmissao;
	}


	public void setDataAdmissao(String dataAdmissao) {
		DataAdmissao = dataAdmissao;
	}


	public String getCargoChefe() {
		return cargoChefe;
	}


	public void setCargoChefe(String cargoChefe) {
		this.cargoChefe = cargoChefe;
	}


	public String getCargoCordenacao() {
		return cargoCordenacao;
	}


	public void setCargoCordenacao(String cargoCordenacao) {
		this.cargoCordenacao = cargoCordenacao;
	}







	public Double CalcularSalarioBruto() {
		Double salarioBruto = SalarioBase;
		if(this.cargoChefe == "sim") {
			salarioBruto = salarioBruto*1.1;
		}
		if(this.cargoCordenacao == "sim") {
			salarioBruto = salarioBruto*1.1;
		}
		return salarioBruto;
	}

	public Double CalcularSalarioLiquido(Double salarioBruto) {
		salarioBruto -= (salarioBruto*0.14);
		if(salarioBruto >= 5000) {
			salarioBruto -= (salarioBruto*0.225);
		}
		return salarioBruto;
	}



}
