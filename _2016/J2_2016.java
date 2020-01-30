package _2016;

import java.util.Scanner;

/**
 * CCC 2016, J2
 * @author Kenneth Tran
 */
public class J2_2016 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[][] square = new int[4][4];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                square[i][j] = scan.nextInt();
            }
        }
        
        int sum = 0;
        
        // Calculate the expected sum
        for (int i = 0; i < 4; i++)
            sum += square[0][i];
        
        for (int i = 0; i < 4; i++) {
            int sum1 = 0, sum2 = 0;

            // Find the sum of each row and column
            for (int j = 0; j < 4; j++) {
                sum1 += square[i][j];
                sum2 += square[j][i];
            }
            
            // If either sum 1 or sum2 does not equal the expected sum, then not magic
            if (sum1 != sum || sum2 != sum) {
                System.out.println("not magic");
                return;
            }
        }
        
        System.out.println("magic");
    }
    
}