package _2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CCC 2020, S2
 * @author Kenneth Tran
 */
public class S2_2020 {
    
    public static int M;
    public static int N;
    
    public static LinkedList<Point>[] nextPoints; // LinkedList for O(1) insertion
    public static int[][] arr;
    
    public static class Point {
        int r;
        int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public LinkedList<Point> getNextPoints() {
            int val = arr[r][c];
            
            if (nextPoints[val] != null)
                return nextPoints[val];
            
            nextPoints[val] = new LinkedList<>();
            
            int inc = val % 2 == 0 ? 1 : 2;
            
            for (int i = 1; i <= Math.sqrt(val); i += inc) { // Only check up to the sqrt of val
                if (val % i == 0) { // If val / i has no remainder, then i is a factor of val
                    int A = i;
                    int B = val / i;
                    
                    // For each factor pair A and B, generate two points: (A, B) and (B, A)

                    if (A > 0 && A <= M && B > 0 && B <= N)
                        nextPoints[val].add(new Point(A, B));
                    if (A > 0 && A <= N && B > 0 && B <= M)
                        nextPoints[val].add(new Point(B, A));
                }
            }
            
            return nextPoints[val];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        nextPoints = new LinkedList[1000001]; // The value of the integer in any cell will never exceed 1 000 000
        
        // arr stores the grid
        arr = new int[M + 1][N + 1];
        
        // read input
        for (int i = 1; i <= M; i++) {
            String[] x = br.readLine().split(" ");
            
            for (int j = 0; j < N; j++) {
                arr[i][j + 1] = Integer.parseInt(x[j]);
            }
        }
        
        // Straight-forward BFS to check if (M, N) is reachable
        boolean[][] visited = new boolean[M + 1][N + 1];
        Queue<Point> queue = new LinkedList<>();
 
        // Start at top-left point (1, 1)
        visited[1][1] = true;
        queue.add(new Point(1, 1));
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            for (Point next : current.getNextPoints()) {
                if (!visited[next.r][next.c]) {
                    visited[next.r][next.c] = true;
                    queue.add(next);
                    
                    if (next.r == M && next.c == N) {
                        System.out.println("yes");
                        return;
                    }
                }
            }
        }
        
        System.out.println("no");
    }
    
}