package _2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * CCC 2016, J3
 * @author Kenneth Tran
 */
public class J3_2016 {
    
    // Check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) { // Check up to the first half of the string
            int p = s.charAt(i); // Count from first index
            int q = s.charAt(s.length() - 1 - i); // Count from last indexs
            
            if (p != q) // If the first pointer and the second pointer aren't equal, not a palindrome
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s = scan.next();

        // All substrings of the string
        Set<String> subs = new HashSet<>();
        
        // Find all substrings of the string
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                subs.add(s.substring(i, j));
            }
        }
        
        // The length of the largest palindrome
        int max = 0;
        
        for (String sub : subs) {
            // Check if the substring is a palindrome AND has the longest length
            if (sub.length() > max && isPalindrome(sub)) {
                max = sub.length(); // Store the length of the palindrome
            }
        }
        
        System.out.println(max);
    }
    
}