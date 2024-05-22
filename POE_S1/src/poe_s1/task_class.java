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
    public static String TaskDescription;
    public static boolean checkTaskDescription;
    public static void Welcome(){
        //System.out.println("Welcome to EasyKanban");
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        
        //Display options menue until user selects exit
        MainMenu();
    }
    
    //This method ensures that the task description is not more than 50 characters.
    public static boolean checkTaskDescription(){
        checkTaskDescription = false;
            while (!checkTaskDescription) {
                TaskDescription = JOptionPane.showInputDialog(null, "Enter task description:");
                
                if (TaskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                } else {
                    //Tasks[i] = TaskDescription;
                    JOptionPane.showMessageDialog(null, "Task successfully captured");
                    checkTaskDescription = true;
                }
            }    
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
                    throw new NumberFormatException("Input is empty");
                }
            
            //Convert
            iInput = Integer.parseInt(input);
            
            if (iInput == 1){
                //Set number tasks
                int NumberTasks;
                String numTasks = JOptionPane.showInputDialog(null,"Please enter the number of tasks you ");
                NumberTasks = Integer.parseInt(numTasks);
                
                 // aArray
                String[] Tasks = new String[NumberTasks];
                
                for (int TaskNumber = 0; TaskNumber < NumberTasks; TaskNumber++) {
                    Tasks[TaskNumber] = JOptionPane.showInputDialog(null, "Enter task " + (TaskNumber + 1) + ":");
                    
                //Check TaskDescripiction    
                checkTaskDescription();    
                //Dev Details
                String DeveloperDetails = JOptionPane.showInputDialog(null, "Enter the first and last name of the developer assigned to the task");
                //Task Duration
                String TaskDur  = JOptionPane.showInputDialog(null, "Enter the estimated duration of the task in hours");
                int TaskDuration = Integer.parseInt(TaskDur);
                
                
                }
                /*try {
                *    if (NumberTasks == null || input.isEmpty()) {
                *        throw new NumberFormatException("Input is empty");
                *    }
                *}catch  (NumberFormatException e) {
                *    JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage() + "\nPlease select a valid option (1-3).");
                *}
                */
            }else if (iInput == 2){
                //Coming soon
                JOptionPane.showMessageDialog(null, "Comming Soon");
            }else if (iInput == 3){
                //Terminate
                JOptionPane.showMessageDialog(null, "Terminating Application");
                System.exit(0);
            }else{
                //User friendly
                JOptionPane.showMessageDialog(null, "THE OPTION YOU HAVE SELECTED IS INVALID '(" + iInput + ")' \n PLEASE SELECT A VALID OPTION (1-3)");
                     
            }
            } catch (NumberFormatException e) { //Error Handling
                JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage() + "\nPlease select a valid option (1-3).");
            }
        }
        
    }                                                                                                                                                                                
    //show message coming soon to instantiate
 
}
