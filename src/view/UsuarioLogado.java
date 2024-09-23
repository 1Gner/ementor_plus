package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.aluno.CadastroAluno;
import view.aluno.ListarAluno;
import view.aluno.ProcurarAluno;
import view.egresso.ListarEgresso;
import view.egresso.selecionaAluno;
import view.professor.CadastroProfessor;
import view.professor.ListarProfessor;
import view.professor.ProcuraProfessor;
import view.turma.turmas;

public class UsuarioLogado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UsuarioLogado frame = new UsuarioLogado();
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
	public UsuarioLogado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Cadastrar Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroAluno cdAluno = new CadastroAluno();
				cdAluno.setVisible(true);
			}
		});
		btnNewButton.setBounds(88, 101, 133, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Listar Aluno");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListarAluno la = new ListarAluno();
				la.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(88, 146, 133, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Alterar Aluno");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProcurarAluno pa = new ProcurarAluno();
				pa.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(88, 197, 133, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Listar Egresso");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListarEgresso le = new ListarEgresso();
				le.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(377, 146, 133, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Aluno Egresso");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecionaAluno sa = new selecionaAluno();
				sa.setVisible(true);

			}
		});
		btnNewButton_4.setBounds(377, 101, 133, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_6 = new JButton("Cadastrar Professor");
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroProfessor cp = new CadastroProfessor();
				cp.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(231, 101, 133, 23);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Listar Professor");
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListarProfessor lp = new ListarProfessor();
				lp.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(231, 146, 133, 23);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Alterar Professor");
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProcuraProfessor pp = new ProcuraProfessor();
				pp.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(231, 197, 133, 23);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("Sair");
		btnNewButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_9.setBounds(574, 330, 89, 23);
		contentPane.add(btnNewButton_9);

		JButton btnNewButton_5 = new JButton("Turmas");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				turmas tm = new turmas();
				tm.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(377, 197, 133, 23);
		contentPane.add(btnNewButton_5);
	}

}
