/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numbers;

/**
 *
 * @author ndlov
 */
import java.util.Scanner;
public class Numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // Declare and initialize the array, already populated
       int[] numbers = {16, 5, 3, 24};
       // Create Scanner
       Scanner scanner = new Scanner(System.in); 
       // User friendly message   
       System.out.print("Do you want to search for a value? (Yes/No): ");   
       String Value = scanner.nextLine(); 
       if (Value == "Yes") {         
           //enter the search value   
           System.out.print("Enter the value to search for: ");  
           int searchValue = scanner.nextInt();       
           // Perform linear search in the array    
           boolean Found = false;          
           for (int i = 0; i < numbers.length; i++) {   
               if (numbers[i] == searchValue) { 
                   Found = true;       
                   break;                 
               } //if          
            } //for     
           // Display the result      
           if (Found) {            
               System.out.println("The value was found in the array.");    
           } else {   
               System.out.println("The value was not found in the array.");  
           } 
        }
     }// end 
}     
    
    

