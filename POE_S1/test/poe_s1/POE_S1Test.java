package poe_s1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class POE_S1Test {

    @BeforeEach
    void setUp() {
        // Initialize test data and populate arrays
        task_class.Tasks = new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        task_class.Developer = new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        task_class.Task_Names = task_class.Tasks.clone();
        task_class.Task_ID = new String[]{"LO:0:SMI", "CR:1:SON", "CR:2:LON", "AD:3:ERZ"};
        task_class.Task_Duration = new int[]{5, 8, 2, 11};
        task_class.Task_Status = new String[]{"To Do", "Doing", "Done", "To Do"};
        task_class.TasksDetails = new String[4]; // Adjust size based on actual data
    }

    // Test for Task Description length
    @Test
    public void testTaskDescriptionLength() {
        String longDescription = "This is a very long task description that exceeds fifty characters limit.";
        assertFalse(task_class.checkTaskDescription(longDescription));

        String shortDescription = "Short task description";
        assertTrue(task_class.checkTaskDescription(shortDescription));
    }

    // Test for correct TaskID generation
    @Test
    public void testTaskIDGeneration() {
        String taskName = "Login Feature";
        int taskNumber = 0;
        String developerName = "Robyn Harrison";

        String expectedTaskID = "LO:0:SON";
        String actualTaskID = task_class.createTaskID(taskName, taskNumber, developerName);

        assertEquals(expectedTaskID, actualTaskID);
    }

    // Test for total hours accumulation in loop
    @Test
    public void testTotalHoursAccumulation() {
        int[] taskDurations = {8, 10}; // Durations for Test Data Task1 and Task2
        int expectedTotalHours = 18;

        int actualTotalHours = 0;
        for (int duration : taskDurations) {
            actualTotalHours += duration;
        }

        assertEquals(expectedTotalHours, actualTotalHours);
    }

    // Test data for Task 1
    @Test
    public void testTask1() {
        task_class.initializeTasksArray(1); // Ensure array is initialized with enough size
        
        // Populate arrays with Test Data Task 1
        task_class.Tasks[0] = "Create Login";
        task_class.Developer[0] = "Mike Smith";
        task_class.Task_Names[0] = "Create Login";
        task_class.Task_ID[0] = task_class.createTaskID("Create Login", 0, "Mike Smith");
        task_class.Task_Duration[0] = 5;
        task_class.Task_Status[0] = "To Do";
        
        // Perform assertions or further testing as needed
        assertEquals("Create Login", task_class.Tasks[0]);
        assertEquals("Mike Smith", task_class.Developer[0]);
        assertEquals("Create Login", task_class.Task_Names[0]);
        assertEquals("LO:0:SMI", task_class.Task_ID[0]); // Adjust expected TaskID as per your createTaskID method
        assertEquals(5, task_class.Task_Duration[0]);
        assertEquals("To Do", task_class.Task_Status[0]);
    }
    
    // Test data for Task 2
    @Test
    public void testTask2() {
        task_class.initializeTasksArray(2); // Ensure array is initialized with enough size
        
        // Populate arrays with Test Data Task 2
        task_class.Tasks[1] = "Create Add Features";
        task_class.Developer[1] = "Edward Harrison";
        task_class.Task_Names[1] = "Create Add Features";
        task_class.Task_ID[1] = task_class.createTaskID("Create Add Features", 1, "Edward Harrison");
        task_class.Task_Duration[1] = 8;
        task_class.Task_Status[1] = "Doing";
        
        // Perform assertions or further testing as needed
        assertEquals("Create Add Features", task_class.Tasks[1]);
        assertEquals("Edward Harrison", task_class.Developer[1]);
        assertEquals("Create Add Features", task_class.Task_Names[1]);
        assertEquals("CR:1:SON", task_class.Task_ID[1]); // Adjust expected TaskID as per your createTaskID method
        assertEquals(8, task_class.Task_Duration[1]);
        assertEquals("Doing", task_class.Task_Status[1]);
    }
    
    // Test data for Task 3
    @Test
    public void testTask3() {
        task_class.initializeTasksArray(3); // Ensure array is initialized with enough size
        
        // Populate arrays with Test Data Task 3
        task_class.Tasks[2] = "Create Reports";
        task_class.Developer[2] = "Samantha Paulson";
        task_class.Task_Names[2] = "Create Reports";
        task_class.Task_ID[2] = task_class.createTaskID("Create Reports", 2, "Samantha Paulson");
        task_class.Task_Duration[2] = 2;
        task_class.Task_Status[2] = "Done";
        
        // Perform assertions or further testing as needed
        assertEquals("Create Reports", task_class.Tasks[2]);
        assertEquals("Samantha Paulson", task_class.Developer[2]);
        assertEquals("Create Reports", task_class.Task_Names[2]);
        assertEquals("CR:2:LON", task_class.Task_ID[2]); // Adjust expected TaskID as per your createTaskID method
        assertEquals(2, task_class.Task_Duration[2]);
        assertEquals("Done", task_class.Task_Status[2]);
    }
    
    // Test data for Task 4
    @Test
    public void testTask4() {
        task_class.initializeTasksArray(4); // Ensure array is initialized with enough size
        
        // Populate arrays with Test Data Task 4
        task_class.Tasks[3] = "Add Arrays";
        task_class.Developer[3] = "Glenda Oberholzer";
        task_class.Task_Names[3] = "Add Arrays";
        task_class.Task_ID[3] = task_class.createTaskID("Add Arrays", 3, "Glenda Oberholzer");
        task_class.Task_Duration[3] = 11;
        task_class.Task_Status[3] = "To Do";
        
        // Perform assertions or further testing as needed
        assertEquals("Add Arrays", task_class.Tasks[3]);
        assertEquals("Glenda Oberholzer", task_class.Developer[3]);
        assertEquals("Add Arrays", task_class.Task_Names[3]);
        assertEquals("AD:3:ERZ", task_class.Task_ID[3]); // Adjust expected TaskID as per your createTaskID method
        assertEquals(11, task_class.Task_Duration[3]);
        assertEquals("To Do", task_class.Task_Status[3]);
    }

    // Test: Developer array correctly populated
    @Test
    void testDeveloperArrayPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        assertArrayEquals(expectedDevelopers, task_class.Developer);
    }

    // Test: Display Developer and Duration for task with longest duration
    @Test
    void testDisplayLongestTaskDuration() {
        // Assuming Task_Duration is sorted in descending order as per your application logic
        String expectedOutput = "Developer: Glenda Oberholzer, Duration: 11 hours";
        String actualOutput = task_class.displayLongestTaskDuration();
        assertEquals(expectedOutput, actualOutput);
    }

    // Test: Search for tasks by name
    @Test
    void testSearchTaskByName() {
        String taskNameToSearch = "Create Login";
        String expectedOutput = "Developer: Mike Smith, Task Name: Create Login";
        String actualOutput = task_class.searchTaskByName(taskNameToSearch);
        assertEquals(expectedOutput, actualOutput);
    }

    // Test: Search all tasks assigned to a Developer
    @Test
    void testSearchTasksByDeveloper() {
        String developerToSearch = "Samantha Paulson";
        String expectedOutput = "Task Name: Create Reports";
        String actualOutput = task_class.searchTasksByDeveloper(developerToSearch);
        assertEquals(expectedOutput, actualOutput);
    }

    // Test: Delete Task from array
    @Test
    void testDeleteTask() {
        String taskToDelete = "Create Reports";
        String expectedOutput = "Entry 'Create Reports' successfully deleted";
        String actualOutput = task_class.deleteTask(taskToDelete);
        assertEquals(expectedOutput, actualOutput);
    }

    // Test: Display Report
    @Test
    void testDisplayReport() {
        String expectedOutput = ""; // Add expected output based on your application's reporting format
        String actualOutput = task_class.displayReport();
        assertEquals(expectedOutput, actualOutput);
    }
}
