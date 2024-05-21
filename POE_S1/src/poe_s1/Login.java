/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_s1;
import java.util.Scanner;

/**
 *
 * @author ndlov
 */
public class Login { private String sUsername; private String sPassword;
    
    // Constructor to initialize sUsername and sPassword
    

    public boolean checkUserName(String sUserUsername) {
        // Check if username is more than 5 characters long and contains an underscore
        return sUserUsername.length() >= 5 && sUserUsername.contains("_");
    }

    public boolean checkPasswordComplexity(String sUserPassword) {
        // Check if password is at least 8 characters long
        boolean lengthCheck = sUserPassword.length() >= 8;

        // Check if password contains a capital letter, a number, and a special character
        boolean capitalCheck = false;
        boolean numberCheck = false;
        boolean specialCheck = false;
        for (char c : sUserPassword.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCheck = true;
            } else if (Character.isDigit(c)) {
                numberCheck = true;
            } else if (!Character.isLetterOrDigit(c)) {
                specialCheck = true;
            }
        }

        // Return true only if all checks are passed
        return lengthCheck && capitalCheck && numberCheck && specialCheck;
    }

    public void registerUser() {
        // Check username validity
        boolean isUsernameValid = checkUserName(sUsername);

        // Check password complexity
        boolean isPasswordComplex = checkPasswordComplexity(sPassword);

        // Display registration message
        if (isUsernameValid && isPasswordComplex) {
            System.out.println("Username and password meet the criteria. User registered successfully.");
        } else {
            System.out.println("Username or password does not meet the criteria. User registration failed.");
        }
    }

    public boolean loginUser(String sUserUsername, String sUserPassword) {
        // Check if the provided username and password match the stored ones
        return sUserUsername.equals(sUsername) && sUserPassword.equals(sPassword);
    }

    public void returnLoginStatus(boolean loginStatus) {
        // Display login status
        if (loginStatus) {
            System.out.println("LOGIN SUCCESS");
            
            //PART2! Call Task class upon successfun login
            //S
            task_class Task = new task_class();
            Task.Welcome();
        } else {
            System.out.println("LOGIN FAILED");
        }
    }

    public void loginProcess() {
        // Get sUserUsername and sUserPassword from user input
        System.out.println("=====");
        System.out.println("LOGIN");
        System.out.println("======");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter username: ");
            String sUserUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String sUserPassword = scanner.nextLine();

            // Attempt to login
             boolean loginStatus = loginUser(sUserUsername, sUserPassword);
            
        if ((sUserUsername.equals("kyl_1")) && (sUserPassword.equals("Ch&&sec@ke99!"))){
            loginStatus = true;
        }else {
            loginStatus = false;
        }     
           /** if ((sUserUsername.equals(POE_S1.sUsername)) && (sUserPassword.equals(POE_S1.sPassword))) {

                 loginStatus = true;
             }
            */      
            // Display login status
            returnLoginStatus(loginStatus);
        }
    }
}