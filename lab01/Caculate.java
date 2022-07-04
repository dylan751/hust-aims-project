/* 
ex 5:  calculate sum, difference, product, and quotient of 2 double numbers which are entered by users
*/
import javax.swing.JOptionPane;

public class Caculate {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the first number: "));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the second number: "));

        String result = "Sum: " + (num1 + num2) + "\nDifference: " + (num1 - num2) + "\nProduct: " + (num1*num2) + "\nQuotient: ";

        if(num2 == 0){
            result += "Error! The second number is 0!";
        }
        else {
            result += (num1/num2);
        }

        JOptionPane.showMessageDialog(null,result, "Show result", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
