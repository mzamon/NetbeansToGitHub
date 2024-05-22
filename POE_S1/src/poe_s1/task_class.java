package poe_s1;

import javax.swing.JOptionPane;

public class task_class {
    public static int TaskNum;
    public static int TotalHours;
    public static String TaskID;
    public static String TaskDetails;
    public static String TaskDescription;
    public static String TaskStatus;
    public static String DeveloperDetails;
    public static boolean checkTaskDescription;
    public static String[] Tasks;

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
                    JOptionPane.showMessageDialog(null, "Coming Soon");
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
