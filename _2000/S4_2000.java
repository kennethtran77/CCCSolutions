package _2000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * CCC 2000, S4
 * @author Kenneth Tran
 */
public class S4_2000 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int distance = scan.nextInt();
        int c = scan.nextInt();
        
        int[] clubs = new int[c];
        
        // Read data
        for (int i = 0; i < c; i++) {
            clubs[i] = scan.nextInt();
        }
        
        // BFS algorithm to find the shortest path
        int[] dist = new int[distance + 1]; // add 1 because one-index
        boolean visited[] = new boolean[distance + 1];
        
        Queue<Integer> queue = new LinkedList<>();

        // Add all the starting points to the queue
        for (int firstClub : clubs) {
            visited[firstClub] = true;
            queue.add(firstClub);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Try all possibilities
            for (int next : clubs) {
                // Add the current to the next to find the next value
                int sum = current + next;

                // If we didn't already visit this value and it doesn't exceed the max distance
                if (sum < visited.length && !visited[sum]) {
                    queue.add(sum);
                    visited[sum] = true;
                    
                    // Store the current level of the BFS
                    dist[sum] = dist[current] + 1;
                    
                    // Stop once we reached the distance
                    if (sum == distance) {
                        System.out.println("Roberta wins in " + (dist[sum] + 1) + " strokes.");
                        return;
                    }
                }
            }
        }
        
        // Couldn't reach the value
        System.out.println("Roberta acknowledges defeat.");
    }
    
}