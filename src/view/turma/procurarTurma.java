package view.turma;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.Sql;
import error.SaveError;

public class procurarTurma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					procurarTurma frame = new procurarTurma();
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
	public procurarTurma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome da turma");
		lblNewLabel.setBounds(153, 65, 109, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(153, 81, 199, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Sql sq = new Sql();
					if(sq.buscaTurma(textField.getText(), Long.parseLong(textField_1.getText())) != null) {
						alunosTurma at = new alunosTurma(textField.getText());
						at.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Turma nao encontrada");
					}

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
		btnNewButton.setBounds(208, 182, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(399, 258, 89, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_1 = new JLabel("Codigo da turma");
		lblNewLabel_1.setBounds(153, 122, 144, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(153, 137, 199, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}