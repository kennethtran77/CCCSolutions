package _2013;

import java.util.Scanner;

/**
 * CCC 2013, S1
 * @author Kenneth Tran
 */
public class S1_2013 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Start 1 year after the input
        int Y = scan.nextInt() + 1;
        
        // Keep increasing Y until we find a distinct year
        while (!isDistinct(Y)) {
            Y++;
        }
        
        System.out.println(Y);
    }
    
    public static boolean isDistinct(int n) {
        // boolean array to store whether each digit from 0-9 has been visited
        boolean[] visited = new boolean[10];
        
        while (n > 0) {
            // get the last digit of n
            int m = n % 10;
            // remove the last digit of n
            n /= 10;
        
            // return false if the last digit of n was already visited
            if (visited[m])
                return false;
            
            // visit the last digit of n
            visited[m] = true;
        }
        
        // all digits are distinct
        return true;
    }
    
}