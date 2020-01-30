package _2016;

import java.util.Scanner;

/**
 * CCC 2016, J4
 * @author Kenneth Tran
 */
public class J4_2016 {
    
    // Convert digital to mins
    public static int toMins(int hours, int mins) {
        return hours * 60 + mins;
    }
    
    // Convert mins to digital
    public static int[] toDigital(int mins) {
        int[] time = new int[2];
        
        time[0] = mins / 60;
        time[1] = mins % 60;
        
        if (time[0] >= 24)
            time[0] -= 24;
        
        return time;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String time = scan.next();
        
        String[] x = time.split(":");
        
        int[] depart = new int[] {Integer.parseInt(x[0]), Integer.parseInt(x[1])};
        int[] arrive;
        
        // Start t at departure time in mins
        int t = toMins(depart[0], depart[1]);
        // Travel until 120 mins after t
        int travel = t + 120;
        
        while (t < travel) {
            // If we are in rush hour, increment travel time by 1 and increment t by 2
            if ((t >= toMins(7, 0) && t < toMins(10, 0)) || (t >= toMins(15, 0) && t < toMins(19, 0))) {
                t += 2;
                travel++;
            } else { // Not in rush hour
                t++;
            }
        }
        
        arrive = toDigital(t);
        
        // Print the result
        System.out.println((arrive[0] < 10 ? "0" : "") + arrive[0] + ":" + (arrive[1] < 10 ? "0" : "") + arrive[1]);

    }
    
}