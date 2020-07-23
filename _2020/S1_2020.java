package _2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * CCC 2020, S1
 * @author Kenneth Tran
 */
public class S1_2020 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] speeds = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] x = br.readLine().split(" ");
            speeds[i][0] = Integer.parseInt(x[0]);
            speeds[i][1] = Integer.parseInt(x[1]);
        }
        
        // Sort speeds in ascending order based on time
        Arrays.sort(speeds, (a, b) -> a[0] - b[0]);
        
        double max = 0;
        
        for (int i = 1; i < N; i++) {
            int x1 = speeds[i - 1][0];
            int x2 = speeds[i][0];
            int y2 = speeds[i - 1][1];
            int y1 = speeds[i][1];

            double speed = Math.abs((double) (y2 - y1) / (double) (x2 - x1));

            max = Math.max(speed, max);
        }
        
        System.out.println(max);
    }
    
}
