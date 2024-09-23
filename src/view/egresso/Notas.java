package view.egresso;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Egressos;

public class Notas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	static Long Matricula;
	static Egressos egresso;
	private JButton btnNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Notas frame = new Notas(egresso);
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
	public Notas(Egressos egresso) {
		Notas.egresso = egresso;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setEnabled(false);
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

		lblNewLabel = new JLabel("Notas do egresso : "+ egresso.getNome());
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
		exibirTabela();







	}
	public void exibirTabela() {
		int i = 0;
		for (Double a : egresso.getNota()) {
			table.setValueAt(a, 0, i);
			i++;
		}
	}

}

