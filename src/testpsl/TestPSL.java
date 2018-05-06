package testpsl;

import java.util.Scanner;

/**
 *
 * @author saaibi
 */
public class TestPSL {

    static final String FINISH = "0,0";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String number;
        LCD lcd = new LCD();
        try {
            try (Scanner lector = new Scanner(System.in)) {
                do {
                    System.out.print("Input: ");
                    number = lector.next();
                    if (!number.equalsIgnoreCase(FINISH)) {
                        lcd.printLCD(number);
                    }
                } while (!number.equalsIgnoreCase(FINISH));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
