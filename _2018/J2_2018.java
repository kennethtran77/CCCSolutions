package _2018;

import java.util.Scanner;

/**
 * CCC 2018, J2
 * @author Kenneth Tran
 */
public class J2_2018 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int counter = 0;
        
        int n = scan.nextInt();
        String yesterday = scan.next();
        String today = scan.next();
        
        for (int i = 0; i < n; i++)
            if (yesterday.charAt(i) == 'C' && today.charAt(i) == 'C')
                counter++;
        
        System.out.println(counter);
    }
    
}