package view;

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

public class Usuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(211, 197, 217, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField = new JTextField();
		textField.setBounds(211, 126, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(211, 113, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(211, 183, 46, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

				}catch(Exception t) {
					System.err.println("Um erro ocorreu: " + t.getMessage());
					SaveError svE = new SaveError();
					ArrayList<String> err = new ArrayList<String>();
					err = (ArrayList<String>) svE.lerDoDisco("erros.dat", err);
					err.add(t.getMessage());

					svE.salvarEmDisco("erros.dat", err);

				}
				Sql sq = new Sql();
				if(sq.login(textField.getText(),textField_1.getText()) != null) {
					UsuarioLogado ul = new UsuarioLogado();
					ul.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Usuario ou senha Errados");
				}
			}
		});
		btnNewButton.setBounds(289, 296, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(571, 425, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
