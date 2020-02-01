package _2012;

import java.util.Scanner;

/**
 * CCC 2012, S5
 * @author Kenneth Tran
 */
public class S5_2012 {
 
    // 0 - empty
    // 1 - cat
    // 2 - brother
    static int[][] lab;
    
    static int paths = 0;
    
    // Simple recursion, no dynamic programming needed
    // Longest test case #5 takes about 7-8 secs, but still passes
    public static void solve(int R, int C) {
        // Out of bounds or ran into a cat
        if (R >= lab.length || C >= lab[0].length || lab[R][C] == 1) {
            return;
        }

        // Found a path
        if (lab[R][C] == 2) {
            paths++;
            return;
        }
        
        // Move right, move down 
        solve(R + 1, C);
        solve(R, C + 1);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int R = scan.nextInt();
        int C = scan.nextInt();
        int K = scan.nextInt();
        
        lab = new int[R][C];
        
        // Mark the brother's spot
        lab[R - 1][C - 1] = 2;
        
        // Mark the cats' spots
        for (int i = 0; i < K; i++) {
            int rk = scan.nextInt();
            int ck = scan.nextInt();
            
            lab[rk - 1][ck - 1] = 1;
        }

        // Solve from the origin
        solve(0, 0);
        
        System.out.println(paths);
    }
    
}