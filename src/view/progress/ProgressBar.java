package view.progress;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class ProgressBar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JProgressBar progressBar = new JProgressBar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ProgressBar frame = new ProgressBar();
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
	public ProgressBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 90);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 0, 332, 51);
		progressBar.setMaximum(100);
		progressBar.setForeground(new Color(50,200,50));
		contentPane.add(progressBar);
		Temp tp = new Temp();
		tp.start();


	}

	public class Temp  extends Thread{
		@Override
		public void run() {
			while(progressBar.getValue() < 100 ) {
				try {
					sleep(10);
					progressBar.setValue(progressBar.getValue()+10);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}

			}
			dispose();

		}
	}

}

