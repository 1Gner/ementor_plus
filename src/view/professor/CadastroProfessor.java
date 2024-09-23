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
import view.progress.ProgressBar;

public class CadastroProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_1_data;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_rua;
	private JTextField textField_5_bairro;
	private JTextField textField_6_cidade;
	private JTextField textField_7_estado;
	private JTextField textField_8_admissao;
	private JTextField textField_11_salario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CadastroProfessor frame = new CadastroProfessor();
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
	public CadastroProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 37, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(10, 62, 96, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(10, 87, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(10, 112, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Rua");
		lblNewLabel_4.setBounds(10, 137, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setBounds(10, 162, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Cidade");
		lblNewLabel_6.setBounds(10, 187, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(10, 212, 46, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Data Admissao");
		lblNewLabel_8.setBounds(10, 237, 96, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Cargo chefe");
		lblNewLabel_9.setBounds(10, 262, 96, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Cargo cordenaçao");
		lblNewLabel_10.setBounds(10, 287, 96, 14);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Salario Base");
		lblNewLabel_11.setBounds(10, 312, 96, 14);
		contentPane.add(lblNewLabel_11);

		textField_nome = new JTextField();
		textField_nome.setBounds(133, 34, 246, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		textField_1_data = new JTextField();
		textField_1_data.setBounds(133, 59, 246, 20);
		contentPane.add(textField_1_data);
		textField_1_data.setColumns(10);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setBounds(133, 84, 246, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setBounds(133, 109, 246, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_rua = new JTextField();
		textField_4_rua.setBounds(133, 134, 246, 20);
		contentPane.add(textField_4_rua);
		textField_4_rua.setColumns(10);

		textField_5_bairro = new JTextField();
		textField_5_bairro.setBounds(133, 159, 246, 20);
		contentPane.add(textField_5_bairro);
		textField_5_bairro.setColumns(10);

		textField_6_cidade = new JTextField();
		textField_6_cidade.setBounds(133, 184, 246, 20);
		contentPane.add(textField_6_cidade);
		textField_6_cidade.setColumns(10);

		textField_7_estado = new JTextField();
		textField_7_estado.setBounds(133, 209, 246, 20);
		contentPane.add(textField_7_estado);
		textField_7_estado.setColumns(10);

		textField_8_admissao = new JTextField();
		textField_8_admissao.setBounds(133, 234, 246, 20);
		contentPane.add(textField_8_admissao);
		textField_8_admissao.setColumns(10);

		textField_11_salario = new JTextField();
		textField_11_salario.setBounds(133, 309, 246, 20);
		contentPane.add(textField_11_salario);
		textField_11_salario.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Nao"}));
		comboBox.setBounds(133, 258, 246, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Nao"}));
		comboBox_1.setBounds(133, 283, 246, 22);
		contentPane.add(comboBox_1);

		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(415, 348, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Sql sq = new Sql();

					ProgressBar pb = new ProgressBar();
					pb.setVisible(true);
					sq.insereDadosProfessor(textField_nome.getText(), textField_1_data.getText(),
							Long.parseLong(textField_2_cpf.getText()),textField_3_telefone.getText() ,
							textField_4_rua.getText(),
							textField_5_bairro.getText(), textField_6_cidade.getText(),
							textField_7_estado.getText(),
							textField_8_admissao.getText(), comboBox.getSelectedItem().toString(),
							comboBox_1.getSelectedItem().toString(), Double.parseDouble(textField_11_salario.getText()));
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
		btnNewButton_1.setBounds(316, 348, 89, 23);
		contentPane.add(btnNewButton_1);


	}
}
