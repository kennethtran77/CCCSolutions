package _2009;

import java.util.Scanner;

/**
 * CCC 2019, S1
 * @author Kenneth Tran
 */
public class S1_2009 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        int count = 0;
        
        // You cannot check every value from a to b since it will time out
        // Instead, check the cubed root from a to b
        
        // Start counting 'i' from the cubed root of a, until the cubed root of b, increment by 1
        for (int i = (int) Math.cbrt(a); i <= (int) Math.cbrt(b); i++) {
            // If i cubed is less than a, then don't count it since it's not in the range
            if (i*i*i < a)
                continue;
            
            // If i**3 is a cube and i**2 is a square
            if (i % 1 == 0 && Math.sqrt(i*i*i) % 1 == 0) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
}