/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_s1;
import javax.swing.JOptionPane;
/**
 *
 * @author ndlov
 */
public class task_class {
    public static void Welcome(){
        //System.out.println("Welcome to EasyKanban");
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        
        //Display options menue until user selects exit
        MainMenu();
    }

    public static void MainMenu(){
        //Have options to add and always return to this menu
        //INPUT MUST BE INT OR ELSE if incorrect RETURN TO MENUE
        int iInput;
        
        String input = JOptionPane.showInputDialog(null, "Select an option\n"
                                                        + "1) ADD TASK\n" 
                                                        + "2) SHOW REPORT\n"  //COMING SOON!
                                                        + "3) QUIT");
        //READ INPUT TO INT
        iInput = Integer.parseInt(input);
        
        while (iInput != 3) {
            
            
            System.out.println("0");
            
            //MAIN MENUE
            input = JOptionPane.showInputDialog(null, "Select an option\n"
                                                        + "1) ADD TASK\n" 
                                                        + "2) SHOW REPORT\n"  //COMING SOON!
                                                        + "3) QUIT");
            //READ INPUT TO INT
            iInput = Integer.parseInt(input);
        }
        
    }                                                                                                                                                                                
    //show message coming soon to instantiate
 
}
