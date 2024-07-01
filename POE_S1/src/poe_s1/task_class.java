package poe_s1;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class task_class {
    public static int TaskNum;
    public static int TempHoursArray;
    public static int TempArrayIndex;
    public static int TotalHours;
    public static String TaskID;
    public static String TaskDetails;
    public static String TaskDescription;
    public static String TaskStatus;
    public static String DeveloperDetails;
    public static boolean checkTaskDescription;
    public static String[] Tasks;
    public static String[] Developer;
    public static String[] Task_Names;
    public static String[] Task_ID;
    public static int[] Task_Duration;
    public static String[] Task_Status;
    public static String[] TasksDetails; 

    public static void Welcome() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        MainMenu();
    }

    // This method ensures that the task description is not more than 50 characters.
    public static boolean checkTaskDescription() {
        checkTaskDescription = false;
        while (!checkTaskDescription) {
            TaskDescription = JOptionPane.showInputDialog(null, "Enter task description:");

            if (TaskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            } else {
                JOptionPane.showMessageDialog(null, "Task successfully captured");
                checkTaskDescription = true;
            }
        }
        return checkTaskDescription;
    }

    // This method creates and returns the taskID
    public static String createTaskID(String taskName, int taskNumber, String developerName) {
        //Get FirstTwo letters of taskname
        String firstTwoLetters = taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase();
        // Extract the last three letters of the developer's name
        String lastThreeLetters = developerName.substring(Math.max(0, developerName.length() - 3)).toUpperCase();
        // Construct the TaskID
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    // This method returns the task full task details of each task.
    public static String printTaskDetails() {
        //Display in order: Task Status, Developer Details, Task Number, Task Name, TaskDescription, Task ID and Duration
        JOptionPane.showMessageDialog(null, "Displaying Task Details");
        
        TaskDetails = TaskStatus + ", " + DeveloperDetails + ", " + TaskNum + ", " + Tasks[TaskNum] + ", " + TaskDescription 
                                + ", " + TaskID + ", " + TotalHours;
        //store to array
        TasksDetails[TempArrayIndex] = TaskDetails;
    
        //Print
        JOptionPane.showMessageDialog(null, TaskDetails);
        return TaskDetails;
    }

    // This method returns the total combined hours of all entered tasks.
    public static int returnTotalHours() {
        //Input hours
        String Hours = JOptionPane.showInputDialog(null, "Enter Hours");
        int iHours;
        iHours = Integer.parseInt(Hours);
        
        //Hold the number of hours to be populated into the array
        TempHoursArray  = iHours;
        TotalHours = TotalHours + iHours;
        return TotalHours;
    }

    public static void MainMenu() {
        int iInput = 0;
        TotalHours = 0;
        while (iInput != 3) {
            String input = JOptionPane.showInputDialog(null, "Select an option\n"
                    + "1) ADD TASK\n"
                    + "2) SHOW REPORT\n"
                    + "3) QUIT");

            try {
                if (input == null || input.isEmpty()) {
                    throw new NumberFormatException("Input is empty");
                }

                iInput = Integer.parseInt(input);

                if (iInput == 1) {
                    int NumberTasks;
                    String numTasks = JOptionPane.showInputDialog(null, "Please enter the number of tasks you have:");
                    NumberTasks = Integer.parseInt(numTasks);
                    initializeTasksArray(NumberTasks);

                    for (int TaskNum = 0; TaskNum < NumberTasks; TaskNum++) {
                        Tasks[TaskNum] = JOptionPane.showInputDialog(null, "Enter task " + (TaskNum + 1) + ":");

                        // Check Task Description    
                        checkTaskDescription();    

                        //Hours
                        returnTotalHours();

                        // Dev Details
                        DeveloperDetails = JOptionPane.showInputDialog(null, "Enter the first and last name of the developer assigned to the task");
                        
                        // Task Duration
                        String taskDur = JOptionPane.showInputDialog(null, "Enter the estimated duration of the task in hours");
                        int taskDuration = Integer.parseInt(taskDur);

                        // Generate TaskID
                        TaskID = createTaskID(Tasks[TaskNum], TaskNum, DeveloperDetails);
                            
                        //Get Task status
                        TaskStatus = JOptionPane.showInputDialog(null, "Enter a task status:\n"
                                                                            + "To Do\n" 
                                                                            + "Done\n" 
                                                                            + "Doing\n");
                        //PART 3 STORE & populate TO ARRAYS
                        Developer[TaskNum] = DeveloperDetails; 
                        //Task name array already implemented for part 2. therefore array Tasks = array Task_Names
                        Task_Names[TaskNum] = Tasks[TaskNum];
                        Task_ID[TaskNum] = TaskID;
                        Task_Duration[TaskNum] = TempHoursArray;
                        Task_Status[TaskNum] = TaskStatus;
                        //Set array index to be used globally
                        TempArrayIndex = TaskNum;
                        //Print
                        
                        printTaskDetails();
                    }
                /*try {
                *    if (NumberTasks == null || input.isEmpty()) {
                *        throw new NumberFormatException("Input is empty");
                *    }
                *}catch  (NumberFormatException e) {
                *    JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage() + "\nPlease select a valid option (1-3).");
                *}
                */    
                } else if (iInput == 2) {
                    //JOptionPane.showMessageDialog(null, "Coming Soon");
                    int iReportInput = 0;
                    while (iReportInput != 7){
                        String ReportInput = JOptionPane.showInputDialog(null, "================ \n Select an option to displ \n ================"
                        + "1) All Tasks\n"                                       
                        + "2) Done Tasks\n"
                        + "3) Longest Task\n"
                        + "4) Search by Task name\n"                                       
                        + "5) Search by Developer\n"                                       
                        + "6) Delete Task\n"                                       
                        + "7) Main Menue\n");
                        
                        iReportInput = Integer.parseInt(ReportInput);
                        
                        if (iReportInput == 1){
                            for (int k = 0; k < Tasks.length ; k++) {
                                //Display all tasks 1 by 1
                                JOptionPane.showMessageDialog(null, TasksDetails[k]);                              
                            }
                            
                        }else if (iReportInput == 2){
                            for (int k = 0; k < Tasks.length ; k++) {
                                //Display all done tasks 1 by 1
                                if (Task_Status[k].equals("Done")){                                   
                                    JOptionPane.showMessageDialog(null, "Developer:\n"+ Developer[k] + "\nTask Name:\n" + Task_Names[k] + "\nTask Duration\n" + Task_Duration[k]);
                                }
                            }    
                        }else if (iReportInput == 3){
                            if (Task_Duration == null || Task_Duration.length == 0) {
                                JOptionPane.showMessageDialog(null, "No tasks have been entered!\n \n PLEASE ENTER TASKS");
                                return;
                            }
                            //Bubble sort Descending
                            String TempDeveloperName = null;
                            int MaximumDuration = Task_Duration[0];
                            for (int s = 0; s < Task_Duration.length; s++) {
                                if (Task_Duration[s] > MaximumDuration) {
                                    MaximumDuration = Task_Duration[s];
                                    //Developer name to match with the hours 
                                    TempDeveloperName = Developer[s];
                                }
                            }

                            JOptionPane.showMessageDialog(null,"Developer:  " + TempDeveloperName + "Highest task duration is: " + MaximumDuration + " hours.");                        
                            
                        }else if (iReportInput == 4){
                            //search by task name
                            String sSearch = JOptionPane.showInputDialog(null, "Please enter the name of the task you would like to display");
                            for (int k = 0; k < Task_Names.length; k++) {
                                    if (Task_Names[k].equals(sSearch)) {
                                        JOptionPane.showMessageDialog(null, "Task name:\n"+ Task_Names[k] + "\nDeveloper:\n" + Developer[k] + "\nTask Satus: \n" + Task_Status[k]);
                                    }                              
                            }
                        }else if (iReportInput == 5){
                            //search by developer
                            String sSearch = JOptionPane.showInputDialog(null, "Please enter the name of the developer you would like to display");
                            for (int k = 0; k < Developer.length; k++) {
                                    if (Developer[k].equals(sSearch)) {
                                        JOptionPane.showMessageDialog(null, "Task name:\n"+ Task_Names[k] + "\nTask Satus: \n" + Task_Status[k]);
                                    }
                            }    
                            
                        }else if (iReportInput == 6){
                            //Search and delete elements
                            String sSearch = JOptionPane.showInputDialog(null, "Please enter the name of the Task you would like to Delete");
                            boolean bFlag = false;
                            // Iterate through Task_Names to find the task
                            for (int k = 0; k < Task_Names.length; k++) {
                                if (Task_Names[k].equals(sSearch)) {
                                    bFlag = true;

                                    // Shift the elements in arrays to delete the task at index k
                                    if (k < Task_Names.length - 1) {
                                        System.arraycopy(Task_Names, k + 1, Task_Names, k, Task_Names.length - 1 - k);
                                        System.arraycopy(Developer, k + 1, Developer, k, Developer.length - 1 - k);
                                        System.arraycopy(Task_ID, k + 1, Task_ID, k, Task_ID.length - 1 - k);
                                        System.arraycopy(Task_Duration, k + 1, Task_Duration, k, Task_Duration.length - 1 - k);
                                        System.arraycopy(Task_Status, k + 1, Task_Status, k, Task_Status.length - 1 - k);
                                        System.arraycopy(TasksDetails, k + 1, TasksDetails, k, TasksDetails.length - 1 - k);
                                    }
                                    //one less element
                                    Task_Names = Arrays.copyOf(Task_Names, Task_Names.length - 1);
                                    Developer = Arrays.copyOf(Developer, Developer.length - 1);
                                    Task_ID = Arrays.copyOf(Task_ID, Task_ID.length - 1);
                                    Task_Duration = Arrays.copyOf(Task_Duration, Task_Duration.length - 1);
                                    Task_Status = Arrays.copyOf(Task_Status, Task_Status.length - 1);
                                    TasksDetails = Arrays.copyOf(TasksDetails, TasksDetails.length - 1);
                                    // Decrease TempArray
                                    if (TempArrayIndex >= Task_Names.length) {
                                        TempArrayIndex--;
                                    }
                                    JOptionPane.showMessageDialog(null, "Task '" + sSearch + "' deleted successfully.");
                                    break; // Exit
                                }
                            }
                            if (!bFlag) {
                                JOptionPane.showMessageDialog(null, "Task '" + sSearch + "' not found.");
                            }
                        }else if (iReportInput == 7){
                            JOptionPane.showMessageDialog(null, "Retuning to Main Menue...");
                            break;
                        }
                    }
                } else if (iInput == 3) {
                    JOptionPane.showMessageDialog(null, "Terminating Application");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "THE OPTION YOU HAVE SELECTED IS INVALID '(" + iInput + ")' \n PLEASE SELECT A VALID OPTION (1-3)");
                }
            } catch (NumberFormatException e) { // Error Handling
                JOptionPane.showMessageDialog(null, "Invalid input: " + e.getMessage() + "\nPlease select a valid option (1-3).");
            }
        }
    }

    public static void initializeTasksArray(int size) {
        Tasks = new String[size];
    }
}
