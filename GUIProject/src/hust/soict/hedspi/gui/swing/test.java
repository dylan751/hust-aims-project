package hust.soict.hedspi.gui.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JList list = new JList();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JList list_1 = new JList();
		contentPane.add(list_1);
		
		JTextArea txtrDuanle = new JTextArea();
		txtrDuanle.setText("Duanle");
		contentPane.add(txtrDuanle);
		contentPane.add(list);
	}
}
