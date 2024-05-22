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
    public static int TaskNum;
    public static int TotalHours;
    public static String TaskID;
    public static String TaskDetails;
    public static boolean checkTaskDescription;
    public static void Welcome(){
        //System.out.println("Welcome to EasyKanban");
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        
        //Display options menue until user selects exit
        MainMenu();
    }
    
    //This method ensures that the task description is not more than 50 characters.
    public static boolean checkTaskDescription(){
        return checkTaskDescription;
    }
    
    //This method creates and returns the taskID
    public static String createTaskID(){
        return TaskID;
    }
    
    //This method returns the task full task details of each task.
    public static String printTaskDetails(){
        return TaskDetails;
    }
    
    //This method returns the total combined hours of all entered tasks.
    public static int returnTotalHours(){
        return TotalHours;
    }
    
    public static void MainMenu(){
        //Have options to add and always return to this menu
        //INPUT MUST BE INT OR ELSE if incorrect RETURN TO MENUE
        int iInput = 0;
        
        while (iInput != 3){ //AND iInput =< 3) {
            /*demo
            *System.out.println("0");
            *demo
            */
            //REVERT BACK TO MAIN MENU
            String input = JOptionPane.showInputDialog(null, "Select an option\n"
                                                        + "1) ADD TASK\n" 
                                                        + "2) SHOW REPORT\n"  //COMING SOON!
                                                        + "3) QUIT");
            
            //Error Handling
             try {
                if (input == null || input.isEmpty()) {
                    throw new NumberFormatException("Input string is empty");
                }
            
            //Convert
            iInput = Integer.parseInt(input);
            
            if (iInput == 1){
                //
            }else if (iInput == 2){
                //Coming soon
                JOptionPane.showMessageDialog(null, "Comming Soon");
            }else if (iInput == 3){
                //Terminate
                JOptionPane.showMessageDialog(null, "Terminating Application");
                System.exit(0);
            }else{
                //User friendly
                JOptionPane.showMessageDialog(null, "THE OPTION YOU HAVE SELECTED IS INVALID \n PLEASE SELECT A VALID OPTION (1-3)");
                     
            }
            } catch (NumberFormatException e) { //Error Handling
                JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage() + "\nPlease select a valid option (1-3).");
            }
        }
        
    }                                                                                                                                                                                
    //show message coming soon to instantiate
 
}
