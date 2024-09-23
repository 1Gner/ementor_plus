package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Egressos;
import model.Professor;
import model.Turma;
import model.Usuario;

public class Sql {

	private final String caminho = "localhost";
	private final String porta = "3306";
	private final String nome = "ementorplus";
	private final String usuario = "root";
	private final String senha = "admin";
	private final String FusoHorario = "?useTimezone=true&serverTimezone=UTC";
	private final String URL = "jdbc:mysql://" + caminho + ":" + porta + "/" + nome + FusoHorario;

	public Connection realizaConexaoMySQL() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public void desconectaMySQL(Connection conexao) {
		try {
			if (conexao != null) {
				conexao.close();
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public void insereDadosAluno(String nome, String dataNascimento, Long cPF, String telefone, String rua,
			String bairro, String cidade, String estado, Long matricula, String periodo, String turma) {
		Connection conexao = realizaConexaoMySQL();

		String sql_aluno = "insert into aluno (Nome,DataNascimento,CPF,Telefone,Rua,Bairro,Cidade,Estado,matricula,periodo,turma,nota1,nota2,nota3,nota4,nota5,nota6,nota7,nota8,nota9,nota10) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement Atuador_aluno = conexao.prepareStatement(sql_aluno);

			Atuador_aluno.setString(1, nome);
			Atuador_aluno.setString(2, dataNascimento);
			Atuador_aluno.setLong(3, cPF);
			Atuador_aluno.setString(4, telefone);
			Atuador_aluno.setString(5, rua);
			Atuador_aluno.setString(6, bairro);
			Atuador_aluno.setString(7, cidade);
			Atuador_aluno.setString(8, estado);
			Atuador_aluno.setDouble(9, matricula);
			Atuador_aluno.setString(10, periodo);
			Atuador_aluno.setString(11, turma);

			for (int i = 0; i < 10; i++) {
				Atuador_aluno.setDouble(12 + i, 0.0);

			}

			Atuador_aluno.execute();

			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public ArrayList<Aluno> recuperaDadosAlunos() {
		Connection conexao = realizaConexaoMySQL();
		ArrayList<Aluno> Academico = new ArrayList<Aluno>();

		try {
			String sql_selecao_aluno = "SELECT *FROM  aluno ;";
			PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
			ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery();

			while (ResultadoSelecao.next()) {
				Aluno ObjetoAluno = new Aluno();
				ArrayList<Double> notas = new ArrayList<Double>();

				ObjetoAluno.setCPF(ResultadoSelecao.getLong("CPF"));
				ObjetoAluno.setNome(ResultadoSelecao.getString("Nome"));
				ObjetoAluno.setDataNascimento(ResultadoSelecao.getString("DataNascimento"));
				ObjetoAluno.setTelefone(ResultadoSelecao.getString("Telefone"));
				ObjetoAluno.setRua(ResultadoSelecao.getString("Rua"));
				ObjetoAluno.setBairro(ResultadoSelecao.getString("Bairro"));
				ObjetoAluno.setCidade(ResultadoSelecao.getString("Cidade"));
				ObjetoAluno.setEstado(ResultadoSelecao.getString("Estado"));
				ObjetoAluno.setMatricula(ResultadoSelecao.getLong("Matricula"));
				ObjetoAluno.setPeriodo(ResultadoSelecao.getString("Periodo"));
				ObjetoAluno.setTurma(ResultadoSelecao.getString("Turma"));

				for (int i = 1; i <= 10; i++) {
					notas.add(ResultadoSelecao.getDouble("nota" + i));
				}
				ObjetoAluno.setNota(notas);

				Academico.add(ObjetoAluno);

			}
			ResultadoSelecao.close();
			atuador_selecao_aluno.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public Aluno buscaAluno(Long matricula) {
		Connection conexao = realizaConexaoMySQL();
		Aluno Academico = new Aluno();
		Academico = null;

		try {
			String sql_selecao_aluno = "SELECT *FROM aluno WHERE matricula=" + matricula + ";";
			PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
			ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery();

			while (ResultadoSelecao.next()) {

				Aluno ObjetoAluno = new Aluno();
				ArrayList<Double> notas = new ArrayList<Double>();

				ObjetoAluno.setCPF(ResultadoSelecao.getLong("CPF"));
				ObjetoAluno.setNome(ResultadoSelecao.getString("Nome"));
				ObjetoAluno.setDataNascimento(ResultadoSelecao.getString("DataNascimento"));
				ObjetoAluno.setTelefone(ResultadoSelecao.getString("Telefone"));
				ObjetoAluno.setRua(ResultadoSelecao.getString("Rua"));
				ObjetoAluno.setBairro(ResultadoSelecao.getString("Bairro"));
				ObjetoAluno.setCidade(ResultadoSelecao.getString("Cidade"));
				ObjetoAluno.setEstado(ResultadoSelecao.getString("Estado"));
				ObjetoAluno.setMatricula(ResultadoSelecao.getLong("Matricula"));
				ObjetoAluno.setPeriodo(ResultadoSelecao.getString("Periodo"));
				ObjetoAluno.setTurma(ResultadoSelecao.getString("Turma"));

				for (int i = 1; i <= 10; i++) {
					notas.add(ResultadoSelecao.getDouble("nota" + i));
				}
				ObjetoAluno.setNota(notas);

				Academico = ObjetoAluno;

			}
			ResultadoSelecao.close();
			atuador_selecao_aluno.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public void deleteAluno(Long matricula) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "DELETE FROM aluno WHERE matricula=" + matricula + ";";

		try {
			PreparedStatement Atuador = conexao.prepareStatement(sql);

			Atuador.execute();

			JOptionPane.showMessageDialog(null, "Dados removidos", "Salvar", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public void atualizaAluno(String nome, String dataNascimento, Long cpf, String telefone, String rua, String bairro,
			String cidade, String estado, Long matricula, String periodo, String turma, Long oldMatricula) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "UPDATE aluno SET nome = ?, dataNascimento = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, "
				+ "cpf = ?, telefone = ?, periodo = ?, matricula = ?, turma = ? WHERE matricula = ?";

		try {
			PreparedStatement atuador = conexao.prepareStatement(sql);
			atuador.setString(1, nome);
			atuador.setString(2, dataNascimento);
			atuador.setString(3, rua);
			atuador.setString(4, bairro);
			atuador.setString(5, cidade);
			atuador.setString(6, estado);
			atuador.setLong(7, cpf);
			atuador.setString(8, telefone);
			atuador.setString(9, periodo);
			atuador.setLong(10, matricula);
			atuador.setString(11, turma);
			atuador.setLong(12, oldMatricula);

			atuador.executeUpdate();

			JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			desconectaMySQL(conexao);
		}
	}

	public void atualizaNotaAluno(Long matricula, Double nota1, Double nota2, Double nota3, Double nota4, Double nota5,
			Double nota6, Double nota7, Double nota8, Double nota9, Double nota10) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "UPDATE aluno set nota1=" + nota1 + ",nota2=" + nota2 + "" + ",nota3=" + nota3 + ",nota4=" + nota4
				+ ",nota5=" + nota5 + ",nota6=" + nota6 + "," + "nota7=" + nota7 + ",nota8=" + nota8 + ",nota9=" + nota9
				+ ",nota10=" + nota10 + "" + " WHERE matricula=" + matricula + ";";

		try {
			PreparedStatement Atuador = conexao.prepareStatement(sql);

			Atuador.execute();

			JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);

	}

	public void insereDadosProfessor(String nome, String dataNascimento, Long cPF, String telefone, String rua,
			String bairro, String cidade, String estado, String dataAdmissao, String cargoChefe, String cargoCordenacao,
			Double salarioBase) {
		Connection conexao = realizaConexaoMySQL();

		String sql_professor = "insert into professor (Nome,DataNascimento,CPF,Telefone,Rua,Bairro,Cidade,Estado,dataAdmissao,cargochefe,cargocordenacao,salarioBase) values (?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement Atuador_professor = conexao.prepareStatement(sql_professor);

			Atuador_professor.setString(1, nome);
			Atuador_professor.setString(2, dataNascimento);
			Atuador_professor.setLong(3, cPF);
			Atuador_professor.setString(4, telefone);
			Atuador_professor.setString(5, rua);
			Atuador_professor.setString(6, bairro);
			Atuador_professor.setString(7, cidade);
			Atuador_professor.setString(8, estado);
			Atuador_professor.setString(9, dataAdmissao);
			Atuador_professor.setString(10, cargoChefe);
			Atuador_professor.setString(11, cargoCordenacao);
			Atuador_professor.setDouble(12, salarioBase);

			Atuador_professor.execute();

			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public ArrayList<Professor> recuperaDadosProfessores() {
		Connection conexao = realizaConexaoMySQL();
		ArrayList<Professor> Academico = new ArrayList<Professor>();

		try {
			String sql_selecao_Professor = "SELECT *FROM  professor ;";
			PreparedStatement atuador_selecao_Professor = conexao.prepareStatement(sql_selecao_Professor);
			ResultSet ResultadoSelecao = atuador_selecao_Professor.executeQuery();

			while (ResultadoSelecao.next()) {
				Professor ObjetoProfessor = new Professor();

				ObjetoProfessor.setCPF(ResultadoSelecao.getLong("CPF"));
				ObjetoProfessor.setNome(ResultadoSelecao.getString("Nome"));
				ObjetoProfessor.setDataNascimento(ResultadoSelecao.getString("DataNascimento"));
				ObjetoProfessor.setTelefone(ResultadoSelecao.getString("Telefone"));
				ObjetoProfessor.setRua(ResultadoSelecao.getString("Rua"));
				ObjetoProfessor.setBairro(ResultadoSelecao.getString("Bairro"));
				ObjetoProfessor.setCidade(ResultadoSelecao.getString("Cidade"));
				ObjetoProfessor.setEstado(ResultadoSelecao.getString("Estado"));
				ObjetoProfessor.setDataAdmissao(ResultadoSelecao.getString("DataAdmissao"));
				ObjetoProfessor.setCargoChefe(ResultadoSelecao.getString("cargoChefe"));
				ObjetoProfessor.setCargoCordenacao(ResultadoSelecao.getString("cargoCordenacao"));
				ObjetoProfessor.setSalarioBase(ResultadoSelecao.getDouble("salarioBase"));

				Academico.add(ObjetoProfessor);

			}
			ResultadoSelecao.close();
			atuador_selecao_Professor.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public Professor buscaProfessor(Long Cpf) {
		Connection conexao = realizaConexaoMySQL();
		Professor Academico = new Professor();
		Academico = null;

		try {
			String sql_selecao_Professor = "SELECT *FROM professor WHERE cpf=" + Cpf + ";";
			PreparedStatement atuador_selecao_Professor = conexao.prepareStatement(sql_selecao_Professor);
			ResultSet ResultadoSelecao = atuador_selecao_Professor.executeQuery();

			while (ResultadoSelecao.next()) {

				Professor ObjetoProfessor = new Professor();

				ObjetoProfessor.setCPF(ResultadoSelecao.getLong("CPF"));
				ObjetoProfessor.setNome(ResultadoSelecao.getString("Nome"));
				ObjetoProfessor.setDataNascimento(ResultadoSelecao.getString("DataNascimento"));
				ObjetoProfessor.setTelefone(ResultadoSelecao.getString("Telefone"));
				ObjetoProfessor.setRua(ResultadoSelecao.getString("Rua"));
				ObjetoProfessor.setBairro(ResultadoSelecao.getString("Bairro"));
				ObjetoProfessor.setCidade(ResultadoSelecao.getString("Cidade"));
				ObjetoProfessor.setEstado(ResultadoSelecao.getString("Estado"));
				ObjetoProfessor.setDataAdmissao(ResultadoSelecao.getString("DataAdmissao"));
				ObjetoProfessor.setCargoChefe(ResultadoSelecao.getString("cargoChefe"));
				ObjetoProfessor.setCargoCordenacao(ResultadoSelecao.getString("cargoCordenacao"));
				ObjetoProfessor.setSalarioBase(ResultadoSelecao.getDouble("salarioBase"));

				Academico = ObjetoProfessor;

			}
			ResultadoSelecao.close();
			atuador_selecao_Professor.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public void atualizaProfessor(String nome, String dataNascimento, Long cpf, String telefone, String rua,
			String bairro, String cidade, String estado, String dataAdmissao, String cargoChefe, String cargoCordenacao,
			Double salarioBase, Long oldCpf) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "UPDATE professor SET nome = ?, dataNascimento = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, "
				+ "cpf = ?, telefone = ?, DataAdmissao = ?, cargoChefe = ?, cargoCordenacao = ?, salarioBase = ? "
				+ "WHERE cpf = ?";

		try {
			PreparedStatement atuador = conexao.prepareStatement(sql);
			atuador.setString(1, nome);
			atuador.setString(2, dataNascimento);
			atuador.setString(3, rua);
			atuador.setString(4, bairro);
			atuador.setString(5, cidade);
			atuador.setString(6, estado);
			atuador.setLong(7, cpf);
			atuador.setString(8, telefone);
			atuador.setString(9, dataAdmissao);
			atuador.setString(10, cargoChefe);
			atuador.setString(11, cargoCordenacao);
			atuador.setDouble(12, salarioBase);
			atuador.setLong(13, oldCpf);

			atuador.executeUpdate();

			JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			desconectaMySQL(conexao);
		}
	}

	public void deleteProfessor(Long cpf) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "DELETE FROM professor WHERE cpf=" + cpf + ";";

		try {
			PreparedStatement Atuador = conexao.prepareStatement(sql);

			Atuador.execute();

			JOptionPane.showMessageDialog(null, "Dados removidos", "Salvar", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public void insereDadosEgresso(String nome, String dataNascimento, Long cPF, String telefone, String rua,
			String bairro, String cidade, String estado, Long matricula, String periodo, String turma,
			List<Double> nota, String profissao, String faixaSalarial, String cursoAnterior, String cursoAtual) {
		Connection conexao = realizaConexaoMySQL();

		String sql_egresso = "INSERT INTO egresso (Nome, DataNascimento, CPF, Telefone, Rua, Bairro, Cidade, Estado, matricula, periodo, "
				+ "turma, profissao, faixaSalarial, cursoAnterior, cursoAtual, nota1, nota2, nota3, nota4, nota5, nota6, nota7, nota8, nota9, nota10) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement atuador_egresso = conexao.prepareStatement(sql_egresso);

			atuador_egresso.setString(1, nome);
			atuador_egresso.setString(2, dataNascimento);
			atuador_egresso.setLong(3, cPF);
			atuador_egresso.setString(4, telefone);
			atuador_egresso.setString(5, rua);
			atuador_egresso.setString(6, bairro);
			atuador_egresso.setString(7, cidade);
			atuador_egresso.setString(8, estado);
			atuador_egresso.setLong(9, matricula);
			atuador_egresso.setString(10, periodo);
			atuador_egresso.setString(11, turma);
			atuador_egresso.setString(12, profissao);
			atuador_egresso.setString(13, faixaSalarial);
			atuador_egresso.setString(14, cursoAnterior);
			atuador_egresso.setString(15, cursoAtual);

			int maxNotas = 10;
			for (int i = 0; i < maxNotas; i++) {
				if (i < nota.size()) {
					atuador_egresso.setDouble(16 + i, 0.0);
				} else {
					atuador_egresso.setDouble(16 + i, 0.0);
				}
			}

			atuador_egresso.execute();

			JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			desconectaMySQL(conexao);
		}
	}

	public ArrayList<Egressos> recuperaDadosEgresso() {
		Connection conexao = realizaConexaoMySQL();
		ArrayList<Egressos> Academico = new ArrayList<Egressos>();

		try {
			String sql_selecao_Egressos = "SELECT *FROM  egresso ;";
			PreparedStatement atuador_selecao_Egressos = conexao.prepareStatement(sql_selecao_Egressos);
			ResultSet ResultadoSelecao = atuador_selecao_Egressos.executeQuery();

			while (ResultadoSelecao.next()) {
				Egressos ObjetoEgressos = new Egressos();

				ObjetoEgressos.setCPF(ResultadoSelecao.getLong("CPF"));
				ObjetoEgressos.setNome(ResultadoSelecao.getString("Nome"));
				ObjetoEgressos.setDataNascimento(ResultadoSelecao.getString("DataNascimento"));
				ObjetoEgressos.setTelefone(ResultadoSelecao.getString("Telefone"));
				ObjetoEgressos.setRua(ResultadoSelecao.getString("Rua"));
				ObjetoEgressos.setBairro(ResultadoSelecao.getString("Bairro"));
				ObjetoEgressos.setCidade(ResultadoSelecao.getString("Cidade"));
				ObjetoEgressos.setEstado(ResultadoSelecao.getString("Estado"));
				ObjetoEgressos.setMatricula(ResultadoSelecao.getLong("Matricula"));
				ObjetoEgressos.setPeriodo(ResultadoSelecao.getString("Periodo"));
				ObjetoEgressos.setProfissao(ResultadoSelecao.getString("Profissao"));
				ObjetoEgressos.setFaixaSalarial(ResultadoSelecao.getString("faixasalarial"));
				ObjetoEgressos.setCursoAnterior(ResultadoSelecao.getString("cursoAnterior"));
				ObjetoEgressos.setCursoAtual(ResultadoSelecao.getString("cursoAtual"));

				Academico.add(ObjetoEgressos);

			}
			ResultadoSelecao.close();
			atuador_selecao_Egressos.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public Egressos buscaEgressos(Long Cpf) {
		Connection conexao = realizaConexaoMySQL();
		Egressos Academico = new Egressos();
		Academico = null;

		try {
			String sql_selecao_Egressos = "SELECT *FROM egresso WHERE cpf=" + Cpf + ";";
			PreparedStatement atuador_selecao_Egressos = conexao.prepareStatement(sql_selecao_Egressos);
			ResultSet ResultadoSelecao = atuador_selecao_Egressos.executeQuery();

			while (ResultadoSelecao.next()) {

				Egressos ObjetoEgressos = new Egressos();

				ObjetoEgressos.setCPF(ResultadoSelecao.getLong("CPF"));
				ObjetoEgressos.setNome(ResultadoSelecao.getString("Nome"));
				ObjetoEgressos.setDataNascimento(ResultadoSelecao.getString("DataNascimento"));
				ObjetoEgressos.setTelefone(ResultadoSelecao.getString("Telefone"));
				ObjetoEgressos.setRua(ResultadoSelecao.getString("Rua"));
				ObjetoEgressos.setBairro(ResultadoSelecao.getString("Bairro"));
				ObjetoEgressos.setCidade(ResultadoSelecao.getString("Cidade"));
				ObjetoEgressos.setEstado(ResultadoSelecao.getString("Estado"));
				ObjetoEgressos.setMatricula(ResultadoSelecao.getLong("Matricula"));
				ObjetoEgressos.setPeriodo(ResultadoSelecao.getString("Periodo"));
				ObjetoEgressos.setProfissao(ResultadoSelecao.getString("Profissao"));
				ObjetoEgressos.setFaixaSalarial(ResultadoSelecao.getString("faixasalarial"));
				ObjetoEgressos.setCursoAnterior(ResultadoSelecao.getString("cursoAnterior"));
				ObjetoEgressos.setCursoAtual(ResultadoSelecao.getString("cursoAtual"));

				Academico = ObjetoEgressos;

			}
			ResultadoSelecao.close();
			atuador_selecao_Egressos.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public void atualizarEgresso(String nome, String dataNascimento, Long cpf, String telefone, String rua,
			String bairro, String cidade, String estado, Long matricula, String periodo, String turma, String profissao,
			String faixaSalarial, String cursoAnterior, String cursoAtual, Long oldCpf) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "UPDATE egresso SET nome = ?, dataNascimento = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, "
				+ "cpf = ?, telefone = ?, matricula = ?, periodo = ?, turma = ?, profissao = ?, faixaSalarial = ?, "
				+ "cursoAnterior = ?, cursoAtual = ? WHERE cpf = ?";

		try {
			PreparedStatement atuador = conexao.prepareStatement(sql);
			atuador.setString(1, nome);
			atuador.setString(2, dataNascimento);
			atuador.setString(3, rua);
			atuador.setString(4, bairro);
			atuador.setString(5, cidade);
			atuador.setString(6, estado);
			atuador.setLong(7, cpf);
			atuador.setString(8, telefone);
			atuador.setLong(9, matricula);
			atuador.setString(10, periodo);
			atuador.setString(11, turma);
			atuador.setString(12, profissao);
			atuador.setString(13, faixaSalarial);
			atuador.setString(14, cursoAnterior);
			atuador.setString(15, cursoAtual);
			atuador.setLong(16, oldCpf);

			atuador.executeUpdate();

			JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			desconectaMySQL(conexao);
		}
	}

	public void deleteEgresso(Long cpf) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "DELETE FROM egresso WHERE cpf=" + cpf + ";";

		try {
			PreparedStatement Atuador = conexao.prepareStatement(sql);

			Atuador.execute();

			JOptionPane.showMessageDialog(null, "Dados removidos", "Salvar", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}



	public Usuario login(String usuario, String senha) {
		Connection conexao = realizaConexaoMySQL();
		Usuario user = null;

		try {

			String sql_selecao_user = "SELECT * FROM usuario WHERE nome = ? AND senha = ?;";
			PreparedStatement atuador_selecao_user = conexao.prepareStatement(sql_selecao_user);


			atuador_selecao_user.setString(1, usuario);
			atuador_selecao_user.setString(2, senha);

			ResultSet resultadoSelecao = atuador_selecao_user.executeQuery();


			if (resultadoSelecao.next()) {
				Usuario ObjetoUsuario = new Usuario();

				ObjetoUsuario.setNomeUsuario(resultadoSelecao.getString("nome"));
				ObjetoUsuario.setSenha(resultadoSelecao.getString("senha"));
				ObjetoUsuario.setNivelAcesso(resultadoSelecao.getInt("nivelAcesso"));

				user = ObjetoUsuario;
			}

			resultadoSelecao.close();
			atuador_selecao_user.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			desconectaMySQL(conexao);
		}

		return user;
	}

	public void insereTurma(String nometurma) {
		Connection conexao = realizaConexaoMySQL();

		String sql_Turma = "insert into turma (Nometurma) values (?)";

		try {
			PreparedStatement Atuador_turma = conexao.prepareStatement(sql_Turma);

			Atuador_turma.setString(1, nometurma);



			Atuador_turma.execute();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public ArrayList<Turma> recuperaTurma() {
		Connection conexao = realizaConexaoMySQL();
		ArrayList<Turma> turma = new ArrayList<Turma>();

		try {
			String sql_selecao_Turma = "SELECT *FROM  turma ;";
			PreparedStatement atuador_selecao_Turma = conexao.prepareStatement(sql_selecao_Turma);
			ResultSet ResultadoSelecao = atuador_selecao_Turma.executeQuery();

			while (ResultadoSelecao.next()) {
				Turma ObjetoTurma = new Turma();

				ObjetoTurma.setNomeTurma(ResultadoSelecao.getString("nometurma"));
				ObjetoTurma.setCodigoTurma(ResultadoSelecao.getLong("codigoturma"));


				turma.add(ObjetoTurma);

			}
			ResultadoSelecao.close();
			atuador_selecao_Turma.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return turma;
	}
	public Turma buscaTurma(String turma,Long codigo) {
		Connection conexao = realizaConexaoMySQL();
		Turma Academico = new Turma();
		Academico = null;

		try {
			String sql_selecao_Turma = "SELECT *FROM turma WHERE nometurma=" + turma + " AND codigoturma="+ codigo +";";
			PreparedStatement atuador_selecao_Turma = conexao.prepareStatement(sql_selecao_Turma);
			ResultSet ResultadoSelecao = atuador_selecao_Turma.executeQuery();

			while (ResultadoSelecao.next()) {

				Turma ObjetoTurma = new Turma();

				ObjetoTurma.setNomeTurma(ResultadoSelecao.getString("nometurma"));
				ObjetoTurma.setCodigoTurma(ResultadoSelecao.getLong("codigoturma"));


				Academico = ObjetoTurma;

			}
			ResultadoSelecao.close();
			atuador_selecao_Turma.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}
}
