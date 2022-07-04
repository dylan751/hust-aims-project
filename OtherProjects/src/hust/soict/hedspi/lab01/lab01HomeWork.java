package hust.soict.hedspi.lab01;

/* 
- Solve the first-degree equation with one variable
- Solve the system of first-degree equations with two variables
- Solve the second-degree equation with one variable
*/

import javax.swing.JOptionPane;
import java.lang.Math;

public class lab01HomeWork {
    public static void main(String[] args) {
        String menu = "1.Solve the first-degree equation with one variable\n2.Solve the system of first-degree equations with two variables\n3.Solve the second-degree equation with one variable\n4.Exit";

        String choice = "";
        double a, b, result = 0; // for first-degree equation

        // var for the system of first-degree equations
        double a11, a12, a21, a22, b1, b2, D, D1, D2;
        String notif2 = "𝑎11𝑥1 + 𝑎12𝑥2 = 𝑏1\n𝑎21𝑥1 + 𝑎22𝑥2 = 𝑏2"; 

        // var for the second-degree equation
        double c, x1, x2, delta; // reuse var a, b above
        String notif3 = "𝑎𝑥^2 +𝑏𝑥 + 𝑐 = 0";

        do{
            choice = JOptionPane.showInputDialog(menu);
            switch (choice) {
                case "1":
                    a = Double.parseDouble(JOptionPane.showInputDialog("ax + b = 0\nEnter a: ")) ;
                    b = Double.parseDouble(JOptionPane.showInputDialog("ax + b = 0\nEnter b: ")) ;
                    if (a == 0) {
                        JOptionPane.showMessageDialog(null,"Error: a = 0!");
                    }
                    else {
                        result = -b/a;
                        JOptionPane.showMessageDialog(null,"x = " + result);
                    }
                    break;

                case "2":
                    a11 = Double.parseDouble(JOptionPane.showInputDialog(notif2 + "\nEnter a11: "));
                    a12 = Double.parseDouble(JOptionPane.showInputDialog(notif2 + "\nEnter a12: "));
                    a21 = Double.parseDouble(JOptionPane.showInputDialog(notif2 + "\nEnter a21: "));
                    a22 = Double.parseDouble(JOptionPane.showInputDialog(notif2 + "\nEnter a22: "));
                    b1 = Double.parseDouble(JOptionPane.showInputDialog(notif2 + "\nEnter b1: "));
                    b2 = Double.parseDouble(JOptionPane.showInputDialog(notif2 + "\nEnter b2: "));
                    
                    
                    D = a11*a22 - a21*a12;
                    D1 = b1*a22 - b2*a12;
                    D2 = a11*b2 - a21*b1;
                    if(D == 0)
                    {
                        if(D1 == D2 && D1 == 0){
                            JOptionPane.showMessageDialog(null, "The system has infinitely many solutions!");
                        }else {
                            JOptionPane.showMessageDialog(null, "The system has no solution!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The system has a unique solution (𝑥1, 𝑥2) = (" + D1/D + ", " + D2/D + ")");
                    }
                    break;

                case "3":
                    a = Double.parseDouble(JOptionPane.showInputDialog(notif3 +"\nEnter a: ")) ;
                    b = Double.parseDouble(JOptionPane.showInputDialog(notif3 +"\nEnter b: ")) ;
                    c = Double.parseDouble(JOptionPane.showInputDialog(notif3 +"\nEnter c: ")) ;

                    if( a == 0 ) {
                        if( b == 0){
                            if( c == 0) {
                                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions!");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "The equation has no solution!");
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "The equation has a unique solution 𝑥1 = " + (-c/b));
                            break;
                        }
                    }
                    delta = b*b - 4*a*c;
                    if(delta == 0) {
                        JOptionPane.showMessageDialog(null, "The equation has double root 𝑥1 = 𝑥2 = " + (-b/(2*a)));
                    }
                    else if(delta > 0){
                        x1 = ((-b + Math.sqrt(delta)) / (2*a));
                        x2 = ((-b - Math.sqrt(delta)) / (2*a));
                        JOptionPane.showMessageDialog(null, "The equation has two distinct roots (𝑥1, 𝑥2) = (" + x1 + ", " + x2 + ")");

                    }else{
                        JOptionPane.showMessageDialog(null, "The equation has no solution!");
                    }

                    break;
                default:
                    break;
            }
        } while (!choice.equals("4"));
        
        System.exit(0);
    }
}