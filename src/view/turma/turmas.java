package view.turma;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.Sql;
import error.SaveError;
import model.Aluno;
import model.Turma;

public class turmas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					turmas frame = new turmas();
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
	public turmas() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"", null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
						"Turma", "Codigo da Turma"
				}
				));


		table.setBounds(84, 40, 413, 224);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 66, 514, 205);
		contentPane.add(scrollPane);


		btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(524, 327, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Ver turma");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					procurarTurma pt = new procurarTurma();
					pt.setVisible(true);
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
		btnNewButton_1.setBounds(40, 327, 89, 23);
		contentPane.add(btnNewButton_1);



		exibirTabela();




	}

	public ArrayList<Turma> crioTurma() {
		Sql sq = new Sql();
		ArrayList<Aluno> aluno = new ArrayList<Aluno>(sq.recuperaDadosAlunos());
		ArrayList<String> nomedaturma = new ArrayList<String>();

		for(Aluno a: aluno) {
			if(!nomedaturma.contains(a.getTurma())) {
				nomedaturma.add(a.getTurma());
			}
		}
		ArrayList<Turma> turm = sq.recuperaTurma();


		for (String nomeTurma : nomedaturma) {
			boolean existe = false;

			for (Turma turma : turm) {
				if (nomeTurma.equals(turma.getNomeTurma())) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				sq.insereTurma(nomeTurma);
			}
		}

		return sq.recuperaTurma();
	}





	public void exibirTabela() {
		ArrayList<Turma> turma = crioTurma();


		int i =0;

		for (Turma a : turma) {
			table.setValueAt(a.getNomeTurma(), i, 0);
			table.setValueAt(a.getCodigoTurma(), i, 1);
			i++;
		}
	}
}
