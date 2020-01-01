package _2012;

import java.util.Scanner;

/**
 * CCC 2012, S2
 * @author Kenneth Tran
 */
public class S2_2012 {

    /**
     * Gets the value of a Roman numeral
     * @param c
     * @return value
     */
    public static int R(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String line = scan.nextLine();
        
        // 2D Array with half the size of the input string as the number of rows, and 2 columns
        // Each row represents a pair of AR, with column 0 being A and column 1 being R
        char[][] ar = new char[line.length() / 2][2];
        
        // Deconstruct the input line into values for the 2D array
        for (int i = 0; i < line.length() - 1; i += 2) {
            ar[i / 2][0] = line.charAt(i);
            ar[i / 2][1] = line.charAt(i + 1);
        }
        
        int total = 0;
        
        // Compare AR with A'R' for every pair of AR
        for (int i = 0; i < ar.length - 1; i++) {
            if (R(ar[i + 1][1]) > R(ar[i][1])) { // If R' is greater than R, substract AR from the total
                total -= Character.getNumericValue(ar[i][0]) * R(ar[i][1]);
            } else { // Otherwise, add AR to the total
                total += Character.getNumericValue(ar[i][0]) * R(ar[i][1]);
            }
        }
        
        // Always add the value of the last pair to the total, since it's never going to be compared
        total += Character.getNumericValue(ar[ar.length - 1][0]) * R(ar[ar.length - 1][1]);
        
        System.out.println(total);
    }
    
}