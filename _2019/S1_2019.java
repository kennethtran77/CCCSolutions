package _2019;

import java.util.Scanner;

/**
 * CCC 2019, S1
 * @author Kenneth Tran
 */
public class S1_2019 {
    
    public static int[][] grid = new int[2][2];
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 3;
        grid[1][1] = 4;
        
        String input = scan.nextLine();
        
        for (char c : input.toCharArray()) {
            if (c == 'V') {
                int a = grid[0][0];
                int b = grid[1][0];
                
                grid[0][0] = grid[0][1];
                grid[1][0] = grid[1][1];
                
                grid[0][1] = a;
                grid[1][1] = b;
            } else {
                int a = grid[0][0];
                int b = grid[0][1];
                
                grid[0][0] = grid[1][0];
                grid[0][1] = grid[1][1];
                
                grid[1][0] = a;
                grid[1][1] = b;
            }
        }
        
        System.out.println(grid[0][0] + " " + grid[0][1]);
        System.out.println(grid[1][0] + " " + grid[1][1]);
    }
    
}