package model;

import java.util.ArrayList;

public class Turma {
	private Long CodigoTurma;
	private String NomeTurma;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();


	public Turma(Long codigoTurma, String nomeTurma, ArrayList<Aluno> alunos) {
		super();
		CodigoTurma = codigoTurma;
		NomeTurma = nomeTurma;
		this.alunos = alunos;
	}


	public Turma() {
		super();
	}


	public Long getCodigoTurma() {
		return CodigoTurma;
	}
	public void setCodigoTurma(Long codigoTurma) {
		CodigoTurma = codigoTurma;
	}
	public String getNomeTurma() {
		return NomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		NomeTurma = nomeTurma;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}




}
