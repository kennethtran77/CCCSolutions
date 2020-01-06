package _2012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * CCC 2012, S3
 * @author Kenneth Tran
 */
public class S3_2012 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        
        int[] R = new int[N];
        int[] freq = new int[1001]; // Represents the frequencies of each reading
        
        int maxFreq = 0; // The highest frequency
        int secondFreq = 0; // The second highest frequency
        
        for (int i = 0; i < N; i++) {
            int reading = scan.nextInt();
            
            R[i] = reading;
            freq[reading]++;
            
            if (freq[reading] > maxFreq) {
                maxFreq = freq[reading]; // Find the first highest frequency
            }
        }
        
        if (maxFreq == 1) { // If the first highest frequency is 1, then so must be the second highest frequency
            secondFreq = 1;
        } else { // Otherwise search for the second highest frequeqncy
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > secondFreq && freq[i] < maxFreq) {
                    secondFreq = freq[i]; // Find the second highest frequency
                }
            }
        }
        
        List<Integer> firstMostFreq = new ArrayList<>(); // A list of all readings that have the highest frequency 
        List<Integer> secondMostFreq = new ArrayList<>();  // A list of all readings that have the second highest frequency 
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                firstMostFreq.add(i);
            }
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == secondFreq) {
                secondMostFreq.add(i);
            }
        }

        Set<Integer> results = new HashSet<>();
        
        if (firstMostFreq.size() > 1) { // First case: more than reading with the largest frequency
            for (int i : firstMostFreq) {
                for (int j : firstMostFreq) {
                    results.add(Math.abs(i - j)); // Add the result from taking the abs difference of the each 1st most frequent reading to each other 1st most frequent reading
                }
            }
        } else { // Second case: only one reading with the largest frequency
            for (int i : firstMostFreq) {
                for (int j : secondMostFreq) {
                    results.add(Math.abs(i - j)); // Add the result from taking the abs difference of the each 1st most frequent reading to each 2nd most frequent reading
                }
            }
        }
        
        System.out.println(Collections.max(results)); // Print the highest value
    }
    
}