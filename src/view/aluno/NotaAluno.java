package view.aluno;

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

public class NotaAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	static Long Matricula;
	static Aluno aluno;
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
					NotaAluno frame = new NotaAluno( aluno, Matricula);
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
	public NotaAluno(Aluno aluno,Long Matricula) {
		NotaAluno.aluno = aluno;
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
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
						"Nota-1", "Nota-2", "Nota-3", "Nota-4", "Nota-5", "Nota-6", "Nota-7", "Nota-8", "Nota-9", "Nota-10"
				}
				));


		table.setBounds(84, 40, 413, 224);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 139, 508, 41);
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Notas do Aluno : "+ aluno.getNome());
		lblNewLabel.setBounds(40, 114, 304, 14);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(524, 327, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Sql sq = new Sql();
					sq.atualizaNotaAluno(Matricula, Double.parseDouble(table.getValueAt(0, 0).toString()),Double.parseDouble(table.getValueAt(0, 1).toString())
							, Double.parseDouble(table.getValueAt(0, 2).toString()),
							Double.parseDouble(table.getValueAt(0, 3).toString())
							,Double.parseDouble(table.getValueAt(0, 4).toString()), Double.parseDouble(table.getValueAt(0, 5).toString())
							, Double.parseDouble(table.getValueAt(0, 6).toString()),
							Double.parseDouble(table.getValueAt(0, 7).toString()),Double.parseDouble( table.getValueAt(0, 8).toString())
							, Double.parseDouble(table.getValueAt(0, 9).toString()));


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
		btnNewButton_1.setBounds(427, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		exibirTabela();







	}
	public void exibirTabela() {
		int i = 0;
		for (Double a : aluno.getNota()) {
			table.setValueAt(a, 0, i);
			i++;
		}
	}

}
