package poe_s1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class POE_S1Test {
    
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
}
