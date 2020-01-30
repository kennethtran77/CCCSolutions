package _2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CCC 2016, S2
 * @author Kenneth Tran
 */
public class S2_2016 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Read input
        int Q = scan.nextInt();
        int N = scan.nextInt();
        
        int[] dmojSpeeds = new int[N];
        int[] pegSpeeds = new int[N];
        
        for (int i = 0; i < N; i++) {
            dmojSpeeds[i] = scan.nextInt();
        } 
        for (int i = 0; i < N; i++) {
            pegSpeeds[i] = scan.nextInt();
        }
        
        int answer = 0;
        
        // Sort both arrays
        Arrays.sort(dmojSpeeds);
        Arrays.sort(pegSpeeds);
        
        if (Q == 1) { // Find the min total speed
            for (int i = 0; i < N; i++) {
                // Iterate through both arrays in ascending order
                // Compare both values at each iteration and return the max value
                answer += Math.max(dmojSpeeds[i], pegSpeeds[i]);
            }
        } else { // Find the max total speed
            for (int i = 0; i < N; i++) {
                // Iterate through first array in ascending order, second array in descending order
                // Compare both values at each iteration and return the max value
                answer += Math.max(dmojSpeeds[i], pegSpeeds[N - i - 1]);
            }
        }
        
        System.out.println(answer);
    }
    
}