package _2003;

import java.util.HashSet;
import java.util.Scanner;

/**
 * CCC 2003, S4
 * @author Kenneth Tran
 */
public class S4_2003 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt(); // number of queries
        String[] q = new String[n]; // queries
        
        for (int i = 0; i < n; i++) {
            q[i] = scan.next();
        }
        
        for (String s : q) {
            HashSet<String> subsets = new HashSet<>(); // Use a set so no duplicate elements are stored
            subsets.add(""); // Add the first subset
            
            for (int i = 0; i < s.length(); i++) { // Start i at 0, loop for length of string, exclusive
                for (int j = i + 1; j <= s.length(); j++) { // Start j at i + 1, loop for length of string, inclusive
                    subsets.add(s.substring(i, j)); // Get a substring from index i to j, add to to the set
                }
            }
            
            System.out.println(subsets.size());
        }
    }
    
}