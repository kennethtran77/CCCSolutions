package _2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CCC 2019, J3
 * @author Kenneth Tran
 */
public class J3_2019 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());
        
        ArrayList<String> output = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();

            char current = s.charAt(0); // The current character we are counting
            int currentCount = 0;
            
            StringBuilder line = new StringBuilder();
            
            for (int j = 0; j < s.length(); j++) {
                if (current != s.charAt(j)) { // If we hit a different character
                    line.append(currentCount).append(" ").append(current).append(" "); // Save what we counted
                    current = s.charAt(j); // Move on to the new character
                    currentCount = 0;
                }
                
                currentCount++;
            }
            
            line.append(currentCount).append(" ").append(current); // Make sure to include the final character because the for loop doesn't account for it

            output.add(line.toString());
        }
        
        for (String s : output)
            System.out.println(s);
    }
    
}