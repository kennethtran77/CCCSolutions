package _2018;

import java.util.Scanner;

/**
 * CCC 2018, J3
 * @author Kenneth Tran
 */
public class J3_2018 {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // distances[] represents the input
        int[] distances = new int[4];
        // cities[] represents the distances of each city from city 1
        int[] cities = new int[5];
        
        // read input into distances[]
        for (int i = 0; i < 4; i++) {
            distances[i] = scan.nextInt();
        }
        
        // the first city is at distance 0
        cities[0] = 0;
        
        // calculate the distance of each city from city 1, which is
        // the distance of the previous city from city 1 plus the distance of the previous city
        // to the current city
        for (int i = 1; i < 5; i++) {
            cities[i] = cities[i - 1] + distances[i - 1];
        }
        
        // loop through each city 5 times
        for (int i = 0; i < 5; i++) {
            // loop through each city 5 more times to find the distance between city i and j
            for (int j = 0; j < 5; j++) {
                System.out.print(Math.abs(cities[i] - cities[j]) + " ");
            }
            
            // print line to move on to next city
            System.out.println();
        }
        
    }
    
}