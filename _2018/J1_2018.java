package _2018;

import java.util.Scanner;

/**
 * CCC 2018, J1
 * @author Kenneth Tran
 */
public class J1_2018 {
    
        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] digits = new int[4];
        
        for (int i = 0; i < digits.length; i++)
            digits[i] = scan.nextInt();
        
        if (digits[0] == 8 || digits[0] == 9)
            if (digits[3] == 8 || digits[3] == 9)
                if (digits[1] == digits[2]) {
                    System.out.println("ignore");
                    return;
                }
        
        System.out.println("answer");
    }
    
}