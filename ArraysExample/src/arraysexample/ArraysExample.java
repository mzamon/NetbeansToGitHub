/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraysexample;
//import java.util.Scanner;
import javax.swing;
import javax.swing.JOptionPane;
/**
 *
 * @author ndlov
 */
public class ArraysExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int Numbers[] = {};
        for (int k=0; k<4; k++){
            String Number = JOptionPane.showInputDialog(null, "Enter a number");
            Numbers[k] = Integer.parseInt(Number);
            System.out.println(Numbers[k]);
        }
        
    }
    
}
