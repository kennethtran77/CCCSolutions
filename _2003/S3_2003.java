package _2003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * CCC 2003, S3
 * @author Kenneth Tran
 */
public class S3_2003 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int flooring = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();
        
        plan = new char[r][c];
        
        // Read input into plan
        for (int i = 0; i < r; i++) {
            String row = scan.next();
            
            for (int j = 0; j < c; j++) {
                plan[i][j] = row.charAt(j);
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (plan[i][j] == '.') { // Check at the first free index
                    roomSizes.add(check(i, j, 0));
                }
            }
        }

        // Sort the roomSizes in descending order
        Collections.sort(roomSizes, Collections.reverseOrder());
        
        // Total rooms that can be completed
        int total = 0;
        
        for (int roomSize : roomSizes) {
            if (flooring - roomSize >= 0) { // Keep going if we have enough flooring to complete the current room
                flooring -= roomSize; // Subtract from our current flooring and add to total completed rooms
                total++;
                continue;
            }
            
            // Stop once we cannot fully complete the current room
            break;
        }
        
        System.out.println(total + " rooms, " + flooring + " square metre(s) left over");
    }
    
    private static char[][] plan;
    private static List<Integer> roomSizes = new ArrayList<>();

    // Use the recursive flood fill algorithm to count the size of each room
    private static int check(int r, int c, int size) {
        // Base case, stop if out of bounds or if we hit a wall
        if (r < 0 || r >= plan.length || c < 0 || c >= plan[0].length || plan[r][c] != '.') {
            return size;
        }
        
        plan[r][c] = 'X'; // Mark this spot so we don't go through it again
        size++; // Count the size of the room
        
        // Check north, south, west, and east and add to our count
        size += check(r - 1, c, 0) + check(r + 1, c, 0) + check(r, c - 1, 0) + check(r, c + 1, 0);
        return size;
    }
    
}