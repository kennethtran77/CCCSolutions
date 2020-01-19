package _2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * CCC 2016, S1
 * @author Kenneth Tran
 */
public class S1_2016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = br.readLine();
        String line2 = br.readLine();

        line2 = line2.replace("*", ""); // Get rid of the wildcards
        
        // Sort the strings to be in alphabetical order
        char[] a = line1.toCharArray();
        char[] b = line2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        // If there were no wildcards, then the length of a must be equal to the length of b
        if (a.length == b.length) {
            System.out.println(Arrays.equals(a, b) ? "A" : "N");
            return;
        }

        // p is used to count the # of characters in b that also appear in a
        int p = 0;
        
        
        // Find the # of intersecting chars
        for (char i : b) {
            for (int j = 0; j < a.length; j++) {
                if (i == a[j] && a[j] != '.') {
                    a[j] = '.'; // Mark the element j in a so we don't recount it
                    p++;
                    break;
                }
            }
        }

        // If p equals the length of b, then we can say that b intersects a, therefore wildcard anagram
        System.out.println(p == b.length ? "A" : "N");
    }
    
}