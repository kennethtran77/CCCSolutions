package _2012;

import java.util.Scanner;

/**
 * CCC 2012, S1
 */
public class S1_2012 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int J = scan.nextInt();
        
        // n Choose R: n! / r! * (n - r)!
        
        int n = J - 1; // substract 1 from n and r because we don't want to count the person who shot the goal
        // r = 3

        // Simplify the formula
        System.out.println(n * (n - 1) * (n - 2) / 6);
    }
    
}