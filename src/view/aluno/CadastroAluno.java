package view.aluno;

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
import view.progress.ProgressBar;

public class CadastroAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_1_DataNascimento;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_rua;
	private JTextField textField_5_bairro;
	private JTextField textField_6_Cidade;
	private JTextField textField_7_estado;
	private JTextField textField_8_matricula;
	private JTextField textField_9_periodo;
	private JTextField textField_10_turma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
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
	public CadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(26, 60, 70, 14);
		contentPane.add(lblNewLabel);

		textField_nome = new JTextField();
		textField_nome.setBounds(147, 57, 362, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		textField_1_DataNascimento = new JTextField();
		textField_1_DataNascimento.setBounds(147, 88, 362, 20);
		contentPane.add(textField_1_DataNascimento);
		textField_1_DataNascimento.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(26, 91, 96, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(26, 126, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(26, 151, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rua");
		lblNewLabel_4.setBounds(26, 176, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setBounds(26, 201, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Cidade");
		lblNewLabel_6.setBounds(26, 226, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(26, 251, 46, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Matricula");
		lblNewLabel_8.setBounds(26, 276, 46, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Periodo");
		lblNewLabel_9.setBounds(26, 298, 46, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Turma");
		lblNewLabel_10.setBounds(26, 323, 46, 14);
		contentPane.add(lblNewLabel_10);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setBounds(147, 119, 362, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setBounds(147, 148, 362, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_rua = new JTextField();
		textField_4_rua.setBounds(147, 173, 362, 20);
		contentPane.add(textField_4_rua);
		textField_4_rua.setColumns(10);

		textField_5_bairro = new JTextField();
		textField_5_bairro.setBounds(147, 198, 362, 20);
		contentPane.add(textField_5_bairro);
		textField_5_bairro.setColumns(10);

		textField_6_Cidade = new JTextField();
		textField_6_Cidade.setBounds(147, 223, 362, 20);
		contentPane.add(textField_6_Cidade);
		textField_6_Cidade.setColumns(10);

		textField_7_estado = new JTextField();
		textField_7_estado.setBounds(147, 248, 362, 20);
		contentPane.add(textField_7_estado);
		textField_7_estado.setColumns(10);

		textField_8_matricula = new JTextField();
		textField_8_matricula.setBounds(147, 273, 362, 20);
		contentPane.add(textField_8_matricula);
		textField_8_matricula.setColumns(10);

		textField_9_periodo = new JTextField();
		textField_9_periodo.setBounds(147, 295, 362, 20);
		contentPane.add(textField_9_periodo);
		textField_9_periodo.setColumns(10);

		textField_10_turma = new JTextField();
		textField_10_turma.setBounds(147, 320, 362, 20);
		contentPane.add(textField_10_turma);
		textField_10_turma.setColumns(10);

		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(588, 400, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Sql sq = new Sql();

					ProgressBar pb = new ProgressBar();
					pb.setVisible(true);
					dispose();
					sq.insereDadosAluno(textField_nome.getText(), textField_1_DataNascimento.getText(), Long.parseLong(textField_2_cpf.getText())
							, textField_3_telefone.getText()
							, textField_4_rua.getText(), textField_5_bairro.getText(), textField_6_Cidade.getText(), textField_7_estado.getText()
							, Long.parseLong(textField_8_matricula.getText()), textField_9_periodo.getText(), textField_10_turma.getText());

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
		btnNewButton_1.setBounds(489, 400, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
