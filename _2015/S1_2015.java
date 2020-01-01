package _2015;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * CCC 2015, S1
 * @author Kenneth Tran
 */
public class S1_2015 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Stack<Integer> stack = new Stack<>();
        
        int k = scan.nextInt();
        
        for (int i = 0; i < k; i++) {
            int x = scan.nextInt();
            
            if (x == 0) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }
        
        int result = 0;
            
        Iterator<Integer> i = stack.iterator();
        
        while (i.hasNext())
            result += stack.pop();
        
        System.out.println(result);
    }
    
}