package _2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CCC 2017, S2
 * @author Kenneth Tran
 */
public class S2_2017 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        
        // The low will have the size of N / 2 rounding up
        int[] low = new int[(int) Math.round((double) N / (double) 2)];
        // The low will have the size of N / 2 rounding down
        int[] high = new int[N / 2];
        
        int[] in = new int[N];
        
        for (int i = 0; i < N; i++) {
            in[i] = scan.nextInt();
        }

        // Sort the input
        Arrays.sort(in);
        
        // Split the first half of the array
        for (int i = 0; i < low.length; i++) {
            low[i] = in[i];
        }
        
        // Split the second half of the array
        for (int i = 0; i < high.length; i++) {
            high[i] = in[low.length + i];
        }

        // For each iteration until N / 2, print out low in descending order followed by high in
        // ascending order
        for (int i = 0; i < low.length; i++) {
            System.out.print(low[low.length - i - 1] + " ");
            
            if (i < high.length)
                System.out.print(high[i] + " ");
        }
        
        System.out.println();
    }
    
}