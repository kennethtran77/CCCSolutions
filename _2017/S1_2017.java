package _2017;

import java.util.Scanner;

/**
 * CCC 2017, S1
 * @author Kenneth Tran
 */
public class S1_2017 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        
        int[] swifts = new int[N];
        int[] semaphores = new int[N];
        
        for (int i = 0; i < N; i++) {
            swifts[i] = scan.nextInt();
        }
        
        for (int i = 0; i < N; i++) {
            semaphores[i] = scan.nextInt();
        }
        
        int a = 0;
        int b = 0;
        
        int max = 0;
        int K = 0;
        
        for (int i = 0; i < N; i++) {
            a += swifts[i];
            b += semaphores[i];
            
            if (a == b) {
                if (max < a) {
                    max = a;
                    K = i + 1;
                }
            }
        }
        
        System.out.println(K);
    }
    
}