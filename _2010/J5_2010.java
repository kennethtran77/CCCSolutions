package _2010;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * CCC 2010, J5
 * @author Kenneth Tran
 */
public class J5_2010 {
 
    public static class Point {
        
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        // Get the 8 different ways you can move from this point as a knight
        public Set<Point> nextMoves() {
            Set<Point> nextMoves = new HashSet<>();
            
            nextMoves.add(new Point(x - 2, y + 1));
            nextMoves.add(new Point(x - 1, y + 2));
            
            nextMoves.add(new Point(x + 1, y + 2));
            nextMoves.add(new Point(x + 2, y + 1));
            
            nextMoves.add(new Point(x - 2, y - 1));
            nextMoves.add(new Point(x - 1, y - 2));
            
            nextMoves.add(new Point(x + 2, y - 1));
            nextMoves.add(new Point(x + 1, y - 2));
            
            return nextMoves;
        }
    }
    
    // Perform a BFS from point (x1, y1)
    public static int solve(int x1, int y1, int x2, int y2) {
        // dist[i][j] holds the distance (# of moves) from point (x1, y1) to (i, j)
        int[][] dist = new int[9][9];
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[9][9];
        
        visited[x1][y1] = true;
        queue.add(new Point(x1, y1));
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            // Loop through all 8 possible moves from point p
            for (Point nextMove : p.nextMoves()) {
                // Skip this move if it leads to out of bounds
                if (nextMove.x < 1 || nextMove.x > 8 || nextMove.y < 1 || nextMove.y > 8)
                    continue;
                
                // Visit this move
                if (!visited[nextMove.x][nextMove.y]) {
                    visited[nextMove.x][nextMove.y] = true;
                    queue.add(nextMove);
                    
                    // The distance of this move from the source (x1, y1)
                    // is the distance of the previous move to the source + 1
                    dist[nextMove.x][nextMove.y] = dist[p.x][p.y] + 1;
                    
                    // If we reached the destination
                    if (nextMove.x == x2 && nextMove.y == y2)
                        return dist[x2][y2];
                }
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        
        System.out.println(solve(x1, y1, x2, y2));
    }
    
}