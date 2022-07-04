package hust.soict.hedspi.lab01;

// Ex3: use dialog print name from var
import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String name;
        name = JOptionPane.showInputDialog("Enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello " + name +", how are you?");

        System.exit(0);
    }
}
