/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ice_4;

/**
 *
 * @author ndlov
 */
import java.util.Scanner;
public class ICE_4 {

    /**
     * @param args the command line arguments
     */
    
    // Method to check if the username and password are correct
    public static boolean authenticate(String username, String password) {
        String Username = "admin";
        String Password = "password";
        
        // Check if the provided username and password match the correct ones
        if (username.equals(Username) && password.equals(Password)) {
            return true;
        } else {
            return false;
        }//if
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User friendly 
        System.out.println("Login System");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        // Authenticate
        boolean isAuthenticated = authenticate(username, password);
        
        // Display appropriate message based on authentication result
        if (isAuthenticated) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        
        scanner.close();
    }
}
