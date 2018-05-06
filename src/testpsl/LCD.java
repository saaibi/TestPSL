package testpsl;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saaibi
 */
public class LCD {

    /**
     *             _ _  _ _
     *            |  UP=5  | 
     *            |        |
     *   LEFT_UP=1|        |RIGHT_UP=3  
     *            |_ _  _ _|      
     *            |MIDDLE=6|
     *            |        |
     * LEFT_DOWN=2|        |RIGHT_DOWN=4
     *            |        |
     *            |_ _  _ _|
     *              DOWN=7
     */
    private static final int LEFT_UP = 1;
    private static final int LEFT_DOWN = 2;
    private static final int RIGHT_UP = 3;
    private static final int RIGHT_DOWN = 4;
    private static final int UP = 5;
    private static final int MIDDLE = 6;
    private static final int DOWN = 7;

    private String[][] matrixResult;

    static final String CHARACTER_COLUMN = "|";
    static final String CHARACTER_ROW = "-";

    private int size;

    private int rows;
    private int columns;
    private int totalRows;
    private int totalColumns;

    private static final Map<Integer, int[]> SEGMENTS = new HashMap<Integer, int[]>() {
        {
            put(1, new int[]{RIGHT_UP, RIGHT_DOWN});
            put(2, new int[]{UP, RIGHT_UP, MIDDLE, LEFT_DOWN, DOWN});
            put(3, new int[]{UP, RIGHT_UP, MIDDLE, RIGHT_DOWN, DOWN});
            put(4, new int[]{LEFT_UP, MIDDLE, RIGHT_UP, RIGHT_DOWN});
            put(5, new int[]{UP, LEFT_UP, MIDDLE, RIGHT_DOWN, DOWN});
            put(6, new int[]{UP, LEFT_UP, MIDDLE, LEFT_DOWN, DOWN, RIGHT_DOWN});
            put(7, new int[]{UP, RIGHT_UP, RIGHT_DOWN});
            put(8, new int[]{LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN, UP, MIDDLE, DOWN});
            put(9, new int[]{LEFT_UP, RIGHT_UP, RIGHT_DOWN, UP, MIDDLE, DOWN});
            put(0, new int[]{LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN, UP, DOWN});

        }
    };

    public void printLCD(String number) throws Exception {
        if (number.matches("[0-9]+,[0-9]+")) {
            splitNumber(number);
        } else {
            throw new IllegalArgumentException("Number " + number + " does not contain the required parameters");
        }
    }

    /**
     * @param numberSplit Number to the split
     */
    private void splitNumber(String numberSplit) {
        String[] numAndSize = numberSplit.split(",");
        if (Integer.parseInt(numAndSize[0]) <= 10 && Integer.parseInt(numAndSize[0]) > 0) {
            createMatrix(Integer.parseInt(numAndSize[0]), numAndSize[1]);
        } else {
            throw new IllegalArgumentException("The size parameter [" + Integer.parseInt(numAndSize[0]) + "] must be between 1 and 10");
        }
    }

    /**
     * @param size 
     * @param numberPrint Number to the print
     * @return matrixResult
     */
    public  String[][] createMatrix(int size, String numberPrint) {

        char[] digits;

        this.size = size;

        this.rows = (2 * this.size) + 3;

        this.columns = this.size + 2;

        this.totalRows = this.rows;

        this.totalColumns = (this.columns * numberPrint.length()) + (numberPrint.length());

        this.matrixResult = new String[this.totalRows][this.totalColumns];

        digits = numberPrint.toCharArray();

        inicializeMatrix();

        createSegment(digits);

        printMatrix();
        
        return this.matrixResult;
    }

    private void inicializeMatrix() {
        for (int i = 0; i < this.totalRows; i++) {
            for (int j = 0; j < this.totalColumns; j++) {
                this.matrixResult[i][j] = " ";
            }
        }
    }

    /**
     * @param digits Digits to print
     */
    private void createSegment(char[] digits) throws NumberFormatException {
        int pivotX = 0;
        for (char digit : digits) {
            int number = Integer.parseInt(String.valueOf(digit));
            addDigit(number, pivotX);
            pivotX = pivotX + this.columns + 1;
        }
    }

    /**
     * @param number Digit
     * @param pivotX Axis x
     */
    private void addDigit(int number, int pivotX) {
        for (int segment : SEGMENTS.get(number)) {
            addSegment(segment, pivotX);
        }
    }

    /**
     * @param segment Segment to add
     * @param pivotX Axis x
     */
    private void addSegment(int segment, int pivotX) {
        int start;
        int end;
        switch (segment) {
            case LEFT_UP:
                addLineVertical(this.matrixResult, start = 0, end = pivotX);
                break;
            case LEFT_DOWN:
                start = this.rows / 2;
                addLineVertical(this.matrixResult, start, end = pivotX);
                break;
            case RIGHT_UP:
                end = (this.columns - 1) + pivotX;
                addLineVertical(this.matrixResult, start = 0, end);
                break;
            case RIGHT_DOWN:
                start = this.columns - 1;
                end = (this.rows / 2) + pivotX;
                addLineVertical(this.matrixResult, start, end);
                break;
            case UP:
                addLineHorizontal(this.matrixResult, start = 0, end = pivotX);
                break;
            case MIDDLE:
                start = this.rows / 2;
                addLineHorizontal(this.matrixResult, start, end = pivotX);
                break;
            case DOWN:
                start = this.rows - 1;
                addLineHorizontal(this.matrixResult, start, end = pivotX);
                break;
            default:
                break;
        }
    }

    /**
     * @param matrix Matrix Impresion
     * @param start Pivot Start in Point
     * @param end Pivot End in Point
     */
    private void addLineVertical(String[][] matrix, int start, int end) {
        for (int i = 1; i <= this.size; i++) {
            matrix[start + i][end] = CHARACTER_COLUMN;
        }
    }

    /**
     * @param matrix Matrix Impresion
     * @param init Pivot Start in Point
     * @param end Pivot End in Point
     */
    private void addLineHorizontal(String[][] matrix, int start, int end) {
        for (int y = 1; y <= this.size; y++) {
            matrix[start][end + y] = CHARACTER_ROW;
        }
    }

    private void printMatrix() {
        for (int i = 0; i < this.totalRows; i++) {
            for (int j = 0; j < this.totalColumns; j++) {
                System.out.print(this.matrixResult[i][j]);
            }
            System.out.println();
        }
    }
}
