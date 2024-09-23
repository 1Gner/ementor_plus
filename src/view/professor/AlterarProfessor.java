package view.professor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.Sql;
import error.SaveError;
import model.Professor;
import view.progress.ProgressBar;

public class AlterarProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Professor professor;
	private JTextField textField_nome;
	private JTextField textField_1_data;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_rua;
	private JTextField textField_5_bairro;
	private JTextField textField_6_cidade;
	private JTextField textField_7_estado;
	private JTextField textField_8_admissao;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_11;
	private JTextField textField_salario;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AlterarProfessor frame = new AlterarProfessor(professor);
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
	public AlterarProfessor(Professor professor) {
		AlterarProfessor.professor = professor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 52, 99, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(10, 77, 99, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(10, 102, 99, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(10, 127, 99, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rua");
		lblNewLabel_4.setBounds(10, 152, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setBounds(10, 177, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Cidade");
		lblNewLabel_6.setBounds(10, 202, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Data Admissao");
		lblNewLabel_7.setBounds(10, 258, 99, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Cargo chefe");
		lblNewLabel_8.setBounds(10, 283, 99, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Estado");
		lblNewLabel_9.setBounds(10, 227, 46, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Cargo cordenacao");
		lblNewLabel_10.setBounds(10, 308, 99, 14);
		contentPane.add(lblNewLabel_10);

		textField_nome = new JTextField();
		textField_nome.setText(professor.getNome());
		textField_nome.setBounds(119, 46, 284, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		textField_1_data = new JTextField();
		textField_1_data.setText(professor.getDataNascimento());
		textField_1_data.setBounds(119, 74, 284, 20);
		contentPane.add(textField_1_data);
		textField_1_data.setColumns(10);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setText(professor.getCPF().toString());
		textField_2_cpf.setBounds(119, 99, 284, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setText(professor.getTelefone());
		textField_3_telefone.setBounds(119, 124, 284, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_rua = new JTextField();
		textField_4_rua.setText(professor.getRua());
		textField_4_rua.setBounds(119, 149, 284, 20);
		contentPane.add(textField_4_rua);
		textField_4_rua.setColumns(10);

		textField_5_bairro = new JTextField();
		textField_5_bairro.setText(professor.getBairro());
		textField_5_bairro.setBounds(119, 174, 284, 20);
		contentPane.add(textField_5_bairro);
		textField_5_bairro.setColumns(10);

		textField_6_cidade = new JTextField();
		textField_6_cidade.setText(professor.getCidade());
		textField_6_cidade.setBounds(119, 199, 284, 20);
		contentPane.add(textField_6_cidade);
		textField_6_cidade.setColumns(10);

		textField_7_estado = new JTextField();
		textField_7_estado.setText(professor.getEstado());
		textField_7_estado.setBounds(119, 224, 284, 20);
		contentPane.add(textField_7_estado);
		textField_7_estado.setColumns(10);

		textField_8_admissao = new JTextField();
		textField_8_admissao.setText(professor.getDataAdmissao().toString());
		textField_8_admissao.setBounds(119, 255, 284, 20);
		contentPane.add(textField_8_admissao);
		textField_8_admissao.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Nao"}));
		comboBox.setBounds(119, 279, 284, 22);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Nao"}));
		comboBox_1.setBounds(119, 304, 284, 22);
		contentPane.add(comboBox_1);



		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(472, 377, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				try {
					Sql sq = new Sql();

					ProgressBar pb = new ProgressBar();
					pb.setVisible(true);
					sq.atualizaProfessor(textField_nome.getText(), textField_1_data.getText(), Long.parseLong(textField_2_cpf.getText())
							, textField_3_telefone.getText()
							, textField_4_rua.getText(), textField_5_bairro.getText(), textField_6_cidade.getText(), textField_7_estado.getText()

							, textField_8_admissao.getText(),comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString() ,Double.parseDouble(textField_salario.getText()),professor.getCPF());
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
		btnNewButton_1.setBounds(373, 377, 89, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_11 = new JLabel("Salario Base");
		lblNewLabel_11.setBounds(10, 333, 99, 14);
		contentPane.add(lblNewLabel_11);

		textField_salario = new JTextField();
		textField_salario.setText(professor.getSalarioBase().toString());
		textField_salario.setBounds(119, 330, 284, 20);
		contentPane.add(textField_salario);
		textField_salario.setColumns(10);

		btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				try {
					Sql sq = new Sql();

					ProgressBar pb = new ProgressBar();
					pb.setVisible(true);
					sq.deleteProfessor(professor.getCPF());

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
		btnNewButton_2.setBounds(10, 377, 89, 23);
		contentPane.add(btnNewButton_2);


	}
}
