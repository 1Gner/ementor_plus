package model;

import java.util.List;

public class Egressos extends Aluno{

	private String profissao;
	private String faixaSalarial;
	private String cursoAnterior;
	private String cursoAtual;





	public Egressos(String nome, String dataNascimento, Long cPF, String telefone, String rua, String bairro,
			String cidade, String estado, Long matricula, String periodo, String turma, List<Double> nota,
			String profissao, String faixaSalarial, String cursoAnterior, String cursoAtual) {
		super(nome, dataNascimento, cPF, telefone, rua, bairro, cidade, estado, matricula, periodo, turma, nota);
		this.profissao = profissao;
		this.faixaSalarial = faixaSalarial;
		this.cursoAnterior = cursoAnterior;
		this.cursoAtual = cursoAtual;
	}


	public Egressos() {
		super();
	}


	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getFaixaSalarial() {
		return faixaSalarial;
	}
	public void setFaixaSalarial(String faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}
	public String getCursoAnterior() {
		return cursoAnterior;
	}
	public void setCursoAnterior(String cursoAnterior) {
		this.cursoAnterior = cursoAnterior;
	}
	public String getCursoAtual() {
		return cursoAtual;
	}
	public void setCursoAtual(String cursoAtual) {
		this.cursoAtual = cursoAtual;
	}



}
