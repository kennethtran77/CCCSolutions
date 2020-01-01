package _2015;

import java.util.Scanner;

/**
 * CCC 2015, S2
 * @author Kenneth Tran
 */
public class S2_2015 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int J = scan.nextInt();
        int A = scan.nextInt();
        
        char[] jerseys = new char[J];
        
        for (int i = 0; i < J; i++) {
            jerseys[i] = scan.next().charAt(0);
        }
        
        int satisfied = 0;
        
        for (int i = 0; i < A; i++) { // Loop through all athletes
            char size = scan.next().charAt(0); // The athlete's desired size
            int num = scan.nextInt(); // The athlete's desired jersey number
            
            if (jerseys[num] != '*') { // If the jersey is not taken
                if (size == 'S' || jerseys[num] == size || (size == 'M' && jerseys[num] == 'L')) { // If the jersey is of the same or a larger size as the athlete
                    satisfied++;
                    jerseys[num] = '*'; // Mark the jersey as taken
                }
            }
        }
        
        System.out.println(satisfied);
    }
    
}