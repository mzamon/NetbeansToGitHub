/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testbankarrays;

/**
 *
 * @author ndlov
 */
import javax.swing.JOptionPane;
public class TestBankArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declare arrays
        String[] arrQuestions ={"What is 1 + 1= ? ; A= 2 ; B=1; C=3",
                            "Who is the current preisdent of South Africa?; A= Ramaphosa; B= Zuma; C= Mandela,",
                            "What is the cube root of 3?; A= 3; B= 9; C= 27",
                            "How many bits are in a byte?; A= 6; B= 8; C= 16",
                            "How may bytes are in a megabyte?:; A= 600; B= 1000000; C= 2400"};
        
        String[] arrAnswers ={"A","A","C","B","B"};
          
        //Start Test
        int Score = 0;
        for (int k = 0; k < 5; k++){
            String Q1 = JOptionPane.showInputDialog(null,arrQuestions[k]);
            if (Q1.equals(arrAnswers[k])) {
                JOptionPane.showMessageDialog(null,"Correct");
                Score++;  
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect!");
                JOptionPane.showMessageDialog(null, arrAnswers[k] + " Is the correct answer!");
            }//if
        }
        JOptionPane.showMessageDialog(null, "Your score is: " + Score + "/5");
    }
    
}
