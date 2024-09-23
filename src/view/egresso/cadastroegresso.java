package view.egresso;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.Sql;
import error.SaveError;
import model.Aluno;
import view.progress.ProgressBar;

public class cadastroegresso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textField_profissao;
	private JTextField textField_1_faixas;
	private JTextField textField_2_canterior;
	private JTextField textField_3_catual;
	static Aluno aluno;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					cadastroegresso frame = new cadastroegresso(aluno);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cadastroegresso(Aluno aluno) {
		cadastroegresso.aluno = aluno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Profissao");
		lblNewLabel.setBounds(26, 60, 70, 14);
		contentPane.add(lblNewLabel);

		textField_profissao = new JTextField();
		textField_profissao.setBounds(147, 57, 362, 20);
		contentPane.add(textField_profissao);
		textField_profissao.setColumns(10);

		textField_1_faixas = new JTextField();
		textField_1_faixas.setBounds(147, 88, 362, 20);
		contentPane.add(textField_1_faixas);
		textField_1_faixas.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Faixa Salarial");
		lblNewLabel_1.setBounds(26, 91, 96, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Curso Anterior");
		lblNewLabel_2.setBounds(26, 126, 96, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CursoAtual");
		lblNewLabel_3.setBounds(26, 151, 96, 14);
		contentPane.add(lblNewLabel_3);

		textField_2_canterior = new JTextField();
		textField_2_canterior.setBounds(147, 119, 362, 20);
		contentPane.add(textField_2_canterior);
		textField_2_canterior.setColumns(10);

		textField_3_catual = new JTextField();
		textField_3_catual.setBounds(147, 148, 362, 20);
		contentPane.add(textField_3_catual);
		textField_3_catual.setColumns(10);

		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(514, 226, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					Sql sq = new Sql();

					ProgressBar pb = new ProgressBar();
					pb.setVisible(true);
					sq.insereDadosEgresso(aluno.getNome(),aluno.getDataNascimento(),aluno.getCPF(),aluno.getTelefone(),aluno.getRua(),aluno.getBairro()
							,aluno.getCidade(),aluno.getEstado(),aluno.getMatricula(),aluno.getPeriodo(),aluno.getTurma(),aluno.getNota(),
							textField_profissao.getText(),textField_1_faixas.getText(),textField_2_canterior.getText(),textField_3_catual.getText());
					;

					sq.deleteAluno(aluno.getMatricula());
					dispose();

				}catch(Throwable t) {
					System.err.println("Um erro ocorreu: " + t.getMessage());
					SaveError svE = new SaveError();
					ArrayList<String> err = new ArrayList<String>();
					err = (ArrayList<String>) svE.lerDoDisco("erros.dat", err);
					err.add(t.getMessage());

					svE.salvarEmDisco("erros.dat", err);

				}


			}
		});
		btnNewButton_1.setBounds(415, 226, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
