package _2002;

import java.util.Scanner;

/**
 * CCC 2002, J5
 * @author Kenneth Tran
 */
public class J5_2002 {
    
    private static char[][] backyard;
    private static String[] moves;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int r = s.nextInt();
        int c = s.nextInt();
        
        backyard = new char[r][c];
        
        // Fill backyard array with input
        for (int i = 0; i < r; i++) {
            String row = s.next();
            
            for (int j = 0; j < c; j++) {
                backyard[i][j] = row.charAt(j);
            }
        }
        
        int m = s.nextInt();
        moves = new String[m];
        
        // Fill moves array with input
        for (int i = 0; i < m; i++) {
            moves[i] = s.next();
        }
        
        // Loop three times for each row, column, and 4 directions
        // in order to check for all possible starting positions
        for (int cr = 0; cr < r; cr++) {
            for (int cc = 0; cc < c; cc++) {
                for (int d = 0; d < 4; d++) {
                    check(cr, cc, d);
                }
            }
        }
        
        // Print backyard array
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(backyard[i][j]);
            }
            
            System.out.println();
        }
    }
    
    /**
     * Checks to see if the starting row, column, and direction will finish at
     * a valid position, given the list of moves. If found, mark the position.
     * 
     * @param r the starting row
     * @param c the starting column
     * @param direction the starting direction (0 - north, 1 - east, 2 - south, 3 - west)
     */
    private static void check(int r, int c, int direction) {
        // If the first position was at an obstacle, stop this check
        if (backyard[r][c] == 'X')
            return;
        
        // Loop through all moves
        for (String move : moves) {
            if (move.equals("R")) {
                direction++;
                
                if (direction > 3) { // Move from west to north
                    direction = 0;
                }
            } else if (move.equals("L")) {
                direction--;
                
                if (direction < 0) { // Move from north to west
                    direction = 3;
                }
            } else if (move.equals("F")) {
                switch (direction) { // Determine the new row/column after moving forward a certain direction
                    case 0: // north
                        r--;
                        break;
                    case 1: // east
                        c++;
                        break;
                    case 2: // south
                        r++;
                        break;
                    case 3: // west
                        c--;
                        break;
                }
                
                // Try to reference the element (t) at backyard[r][c] after moving forward
                // 
                // If out of bounds exception caught, stop this check
                // If 't' is an obstacle, stop this check
                try {
                    char t = backyard[r][c];

                    if (t == 'X') { 
                        return;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return;
                }
            }
        }
        
        // The for loop fully completed, therefore found valid position. Mark end position
        backyard[r][c] = '*';
    }
    
}