package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;
public class AWTCounter extends Frame {

	// khai bao cac component tren giao dien
	private Label lblCount;
	private TextField tfCount;
	private Button btnCount;
	private int count;
	
	// constructor cho AWTCounter:
	public AWTCounter() {
		// thiet lap layout cho cua so giao dien
		// FlowLayout: bo cuc don gian, co san: component nao dc them vao truoc thi xuat hien truoc
		// neu khong du cho thi xuong hang moi
		this.setLayout(new FlowLayout());
		
		// khoi tao cac component va them vao giao dien
		lblCount = new Label("Counter");
		this.add(lblCount);
		
		tfCount = new TextField(count + "", 10);
		tfCount.setEditable(false);
		this.add(tfCount);
		
		btnCount = new Button("Count");
		this.add(btnCount);
		// dang ki lang nghe su kien tren btn
		btnCount.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						++count;
						tfCount.setText(count + "");
					}
				}
				);
		
		
		
		// thiet lap thong tin cua so giao dien
		this.setTitle("AWT Counter");
		this.setSize(250, 100);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		AWTCounter app = new AWTCounter();
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		++count;
//		this.tfCount.setText(count + "");
//	}

}
