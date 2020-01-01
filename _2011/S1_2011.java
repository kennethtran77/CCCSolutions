package _2011;

import java.util.Scanner;

/**
 * CCC 2011, S1
 * @author Kenneth Tran
 */
public class S1_2011 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine());
        
        int s = 0;
        int t = 0;
        
        String[] lines = new String[N];
        
        for (int i = 0; i < N; i++) {
            lines[i] = scan.nextLine();
        }
        
        for (int i = 0; i < N; i++) {
            for (char c : lines[i].toCharArray()) {
                if (c == 't' || c == 'T') {
                    t++;
                } else if (c == 's' || c == 'S') {
                    s++;
                }
            }
        }
        
        if (s >= t) {
            System.out.println("French");
        } else {
            System.out.println("English");
        }
    }
    
}