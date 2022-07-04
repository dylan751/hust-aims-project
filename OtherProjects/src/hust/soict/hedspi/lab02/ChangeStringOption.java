package hust.soict.hedspi.lab02;


import javax.swing.JOptionPane;

public class ChangeStringOption {

	public static void main(String[] args) {
		// TODO_Auto-generated method stub
		int option = JOptionPane.showConfirmDialog(null, "Do you want to ...?");
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
		
		System.exit(0);
	}

}
