package _2011;

import java.util.Scanner;

/**
 * CCC 2011, S2
 * @author Kenneth Tran
 */
public class S2_2011 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine());
        
        int correct = 0;
        
        char[] a = new char[N*2];
        
        for (int i = 0; i < N*2; i++) {
            a[i] = scan.next().charAt(0);
        }
        
        for (int i = 0; i < N; i++) {
            if (a[i] == a[N + i]) {
                correct++;
            }
        }
        
        System.out.println(correct);
    }
    
}