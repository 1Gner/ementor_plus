package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

	private Long Matricula;
	private String Periodo;
	private String Turma;
	private List<Double> Nota = new ArrayList<Double>(10);


	public Aluno(String nome, String dataNascimento, Long cPF, String telefone, String rua, String bairro,
			String cidade, String estado, Long matricula, String periodo, String turma, List<Double> nota) {
		super(nome, dataNascimento, cPF, telefone, rua, bairro, cidade, estado);
		Matricula = matricula;
		Periodo = periodo;
		Turma = turma;
		Nota = nota;
	}




	public Aluno() {
		super();
	}




	public Long getMatricula() {
		return Matricula;
	}


	public void setMatricula(Long matricula) {
		Matricula = matricula;
	}


	public String getPeriodo() {
		return Periodo;
	}


	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}


	public String getTurma() {
		return Turma;
	}


	public void setTurma(String turma) {
		Turma = turma;
	}


	public List<Double> getNota() {
		return Nota;
	}


	public void setNota(List<Double> nota) {
		Nota = nota;
	} ;




}
