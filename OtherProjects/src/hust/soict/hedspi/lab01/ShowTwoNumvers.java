package hust.soict.hedspi.lab01;

// ex 4: show two number from user input numbers
import javax.swing.JOptionPane;

public class ShowTwoNumvers {
    public static void main(String[] args) {
        String num1, num2;

        num1 = JOptionPane.showInputDialog("Enter the first number: ");
        num2 = JOptionPane.showInputDialog("Enter the second number: ");

        String result = "You entered: " + num1 + " and " + num2;

        JOptionPane.showMessageDialog(null, result, "show two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
