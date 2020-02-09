package _2013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * CCC 2013, S2
 * @author Kenneth Tran
 */
public class S2_2013 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int W = scan.nextInt();
        int N = scan.nextInt();
        
        Queue<Integer> cars = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            cars.add(scan.nextInt());
        }
        
        // The queue represents how many cars are currently on the bridge
        Queue<Integer> queue = new LinkedList<>();
        
        int T = 0;
        int weight = 0;
        
        // Keep loading cars until we run out
        while (!cars.isEmpty()) {
            // Keep adding cars until we reach the max of 4
            if (queue.size() < 4) {
                int c = cars.remove();
                
                // If either this car is greater than the max weight or adding it will exceed the max weight, then stop
                if (c > W || weight + c > W) {
                    System.out.println(T);
                    return;
                }
                
                // Add the car to the queue, count it, and add its weight
                queue.add(c);
                weight += c;
                T++;
            } else {
                // Subtract the current weight after removing the car at the front
                weight -= queue.poll();
            }
        }
        
        // All cars made it through
        System.out.println(T);
    }
    
}