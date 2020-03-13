package _2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * CCC 2020, S1
 * @author Kenneth Tran
 */
public class S1_2020 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // A TreeMap will sort key value pairs in ascending order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] x = br.readLine().split(" ");
            map.put(Integer.parseInt(x[0]), Integer.parseInt(x[1]));
        }
        
        double max = 0;
        
        int[] time = new int[N];
        int[] pos = new int[N];
        
        int i = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            time[i] = entry.getKey();
            pos[i] = entry.getValue();
            
            i++;
        }
        
        for (int j = 1; j < N; j++) {
            int x1 = time[j - 1];
            int x2 = time[j];
            int y2 = pos[j - 1];
            int y1 = pos[j];

            double speed = Math.abs((double) (y2 - y1) / (double) (x2 - x1));

            if (speed > max) {
                max = speed;
            }
        }
        
        System.out.println(max);
    }
    
}