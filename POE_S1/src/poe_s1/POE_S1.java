/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_s1;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ndlov
 */
public class POE_S1 {

    /**
     * @param args the command line arguments
     */
    public static boolean CheckUserName(String sUsername) {
        // Check if username is more than 5 characters long and contains an underscore
        if (sUsername.length() >= 5 && sUsername.contains("_")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean CheckPasswordComplexity(String sPassword) {
        // Check if password is at least 8 characters long
        boolean lengthCheck = sPassword.length() >= 8;
        
        // Check if password contains a capital letter
        boolean capitalCheck = false;
        for (char c : sPassword.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCheck = true;
                break;
            }
        }
        
        // Check if password contains a number
        boolean numberCheck = false;
        for (char c : sPassword.toCharArray()) {
            if (Character.isDigit(c)) {
                numberCheck = true;
                break;
            }
        }
        
        // Check if password contains a special character
        boolean specialCheck = false;
        for (char c : sPassword.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialCheck = true;
                break;
            }
        }
        
        // Return true only if all checks are passed
        return lengthCheck && capitalCheck && numberCheck && specialCheck;
    }

    public static void main(String[] args) {
        // Create a Scanner that will read username and password into a group of variables
        Scanner scanner = new Scanner(System.in);

        //scaner inputs
        System.out.print("Enter username: ");
        String sUsername = scanner.nextLine();
        
        //Check username & display user friendly
        boolean IsUsernameValid = CheckUserName(sUsername);
        //JOptionPane.showMessageDialog(null,"USERNAME IS VALID!");
        if (IsUsernameValid) {
            //System.out.println("USERNAME IS VALID!");
            System.out.println("Username successfully captured!");
        } else {
            //System.out.println("USERNAME IS INVALID!");
            System.out.println("Username is not correctly formatted,"
                    + " please ensure that your username contains an underscore "
                    + "and is no more than 5 characters in length.");
        }
        
        
        System.out.print("Enter password: ");
        String sPassword = scanner.nextLine();
         // Check password & display user friendly
        boolean IsPasswordValid = CheckPasswordComplexity(sPassword);
        if (IsPasswordValid){
            //System.out.println("Password Is Complex!");
            System.out.println("Password successfully captured!");
        } else {
            //System.out.println("Password IS NOT Complex!");
            System.out.println("Password is not correctly formatted,"
                    + " please ensure that the password contains at least 8 characters,"
                    + " a capital letter, a number and a special character.");
        }
    
        
        System.out.print("Enter name: ");
        String sName = scanner.nextLine();
        
        System.out.print("Enter surname: ");
        String sSurname = scanner.nextLine();

        // Close
        scanner.close();
    }
}