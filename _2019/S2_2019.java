package _2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CCC 2019, S2
 * @author Kenneth Tran
 */
public class S2_2019 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int T = scan.nextInt(); // Test cases
        
        int[] cases = new int[T];
        int n = 0; // n represents the cap of primes
        
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            
            cases[i] = N;
            
            if (n < 2*N) // Only go up to 2N, in order to not generate more primes than needed
                n = 2*N; // In the worst case scenario (N = 1 000 000), we will generate all primes up to 2 000 000
        }
        
        // boolean array: false = prime, true = composite
        boolean sieve[] = new boolean[n + 1];
        
        // Sieve of Eratosthenes
        for (int i = 2; i < Math.sqrt(n); i++) { // Start i at 2, increment by 1 until the square root of n
            if (!sieve[i]) { // If i is marked as false
                for (int j = i * i; j < n; j += i) { // Start at the square of i, then loop through all multiples of i and mark them as true
                    sieve[j] = true;
                }
            }
        } // By the end of this algorithm, all unmarked values (false) represents a prime
        
        List<Integer> primes = new ArrayList<>();
        
        // Check values from 2 to N
        for (int i = 2; i <= n; i++) {
            if (!sieve[i]) {
                primes.add(i); // Add the prime to an ArrayList
            }
        }
        
        /* THIS WILL TIME OUT!
        cases:
        for (int i = 0; i < T; i++) {
            for (int a : primes) {
                for (int b : primes) {
                    if (a + b == cases[i] * 2) {
                        System.out.println(a + " " + b);
                        continue cases;
                    }
                }
            }
        }
        */
        
        // Optimized solution
        for (int i = 0; i < T; i++) {
            for (int a : primes) { // Loop through primes, let A represent each prime
                // 2N = A + B
                // So, B = 2N - A
                // And if B is unmarked in the sieve, i.e. B is a prime number,
                // then A and B must both be primes, so these are our 2 numbers
                int b = cases[i] * 2 - a;
                
                if (!sieve[b]) {
                    System.out.println(a + " " + b);
                    break;
                }
            }
        }
    }
    
}
