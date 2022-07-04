package hust.soict.hedspi.gui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingDemo extends JFrame {
	
	private JLabel lblCount;
	private JTextField tfCount;
	private JButton btnCount;
	private int count;
	
	public SwingDemo() {
		this.setLayout(new FlowLayout());
		
		lblCount = new JLabel("Swing Counter");
		this.add(lblCount);
		
		tfCount = new JTextField(count + "", 10);
		tfCount.setEditable(false);
		this.add(tfCount);
		
		btnCount = new JButton("Count");
		this.add(btnCount);
		btnCount.addActionListener(
			new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					++count;
					tfCount.setText(count + "");
				}
			}
		);
		
		this.setTitle("Swing Counter");
		this.setSize(250,100);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new SwingDemo();				
			}
		});
	}
}
