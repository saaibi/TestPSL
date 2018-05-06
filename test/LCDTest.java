/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testpsl.LCD;

/**
 *
 * @author saaib
 */
public class LCDTest {

    
    LCD lcd = new LCD();
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void printLCDSizeNoValid() throws Exception {
        lcd.printLCD("11,123456789");
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void printLCDNoValidDigit() throws Exception {
       lcd.printLCD("10,3,6");
    }
    
    @Test()
    public void printLCDnumberZero() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "0");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {"|", " ", "|", " "},
            {" ", " ", " ", " "},
            {"|", " ", "|", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Zero");
    }

    @Test()
    public void printLCDnumberOne() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "1");
        String[][] resultExpected = new String[][]{
            {" ", " ", " ", " "},
            {" ", " ", "|", " "},
            {" ", " ", " ", " "},
            {" ", " ", "|", " "},
            {" ", " ", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number One");
    }

    @Test()
    public void printLCDnumberTwo() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "2");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", "-", " ", " "},
            {"|", " ", " ", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Two");
    }

    @Test()
    public void printLCDnumberThree() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "3");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Three");
    }

    @Test()
    public void printLCDnumberFour() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "4");
        String[][] resultExpected = new String[][]{
            {" ", " ", " ", " "},
            {"|", " ", "|", " "},
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", " ", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Four");
    }

    @Test()
    public void printLCDnumberFive() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "5");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {"|", " ", " ", " "},
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Five");
    }

    @Test()
    public void printLCDnumberSix() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "6");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {"|", " ", " ", " "},
            {" ", "-", " ", " "},
            {"|", " ", "|", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Six");
    }

    @Test()
    public void printLCDnumberSeven() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "7");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", " ", " ", " "},
            {" ", " ", "|", " "},
            {" ", " ", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Seven");
    }

    @Test()
    public void printLCDnumberEight() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "8");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {"|", " ", "|", " "},
            {" ", "-", " ", " "},
            {"|", " ", "|", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Eight");
    }

    @Test()
    public void printLCDnumberNine() throws Exception {
        String[][] resultCurrent = lcd.createMatrix(1, "9");
        String[][] resultExpected = new String[][]{
            {" ", "-", " ", " "},
            {"|", " ", "|", " "},
            {" ", "-", " ", " "},
            {" ", " ", "|", " "},
            {" ", "-", " ", " "}
        };
        assertEquals(resultCurrent, resultExpected, "Error Number Nine");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
