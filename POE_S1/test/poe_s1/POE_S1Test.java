/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe_s1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ndlov
 */
public class POE_S1Test {
    
    public POE_S1Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of CheckUserName method, of class POE_S1.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("CheckUserName");
        String sUsername = "";
        boolean expResult = false;
        boolean result = POE_S1.CheckUserName(sUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckPasswordComplexity method, of class POE_S1.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("CheckPasswordComplexity");
        String sPassword = "";
        boolean expResult = false;
        boolean result = POE_S1.CheckPasswordComplexity(sPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class POE_S1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        POE_S1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
