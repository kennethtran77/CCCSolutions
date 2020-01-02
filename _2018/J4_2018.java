package _2018;

import java.util.Scanner;

/**
 * CCC 2018, J4
 * @author Kenneth Tran
 */
public class J4_2018 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine()); // Rows and columns
        int[][] table = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                table[i][j] = scan.nextInt(); // Read input

        if (table[0][0] < table[0][n-1] && table[0][0] < table[n-1][0]) { // If rotated bj 0/360
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(table[i][j] + " "); // Print as is, no changes needed

                System.out.println();
            }
        } else if (table[0][0] > table[0][n-1] && table[0][0] < table[n-1][0]) { // If rotated by 90
            for (int i = n-1; i >= 0; i--) { // Start at last column and go left
                for (int j = 0; j < n; j++) // Start at first row and go down
                    System.out.print(table[j][i] + " ");

                System.out.println();
            }
        } else if (table[0][0] > table[0][n-1] && table[0][0] > table[n-1][0]) { // If rotated by 180
            for (int j = n-1; j >= 0; j--) { // Start at last row and go up
                for (int i = n-1; i >= 0; i--) // Start at last column and go left
                    System.out.print(table[j][i] + " ");

                System.out.println();
            }
        } else if (table[0][0] < table[0][n-1] && table[0][0] > table[n-1][0]) { // If rotated by 270
            for (int i = 0; i < n; i++) { // Start at first column and go right
                for (int j = n-1; j >= 0; j--) // Start at last row and go up
                    System.out.print(table[j][i] + " ");

                System.out.println();
            }
        }
    }
    
}