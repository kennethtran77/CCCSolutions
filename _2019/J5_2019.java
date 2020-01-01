package _2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * CCC 2019, J5
 * @author Kenneth Tran
 */
public class J5_2019 {

    // Simply represents a step
    public static class Step {
        
        public int rule;
        public int index;
        public String result;
        
        public Step(int rule, int index, String result) {
            this.rule = rule;
            this.index = index;
            this.result = result;
        }

    }

    // Returns a list of integers containing the indices where the substring is located
    public static List<Integer> getOcurrencesIndices(String string, String substring) {
        List<Integer> indices = new ArrayList<>();

        int i = 0;

        while (i != -1) { // Keep going until indexOf returns -1, i.e. there are no more occurences of this substring
            i = string.indexOf(substring, i); // Find the index at which the substring occurs, starting from index i

            if (i != -1) { // If there was a match
                indices.add(i); // Store that index
                i++; // Move the pointer forward by 1
            }
        }
        
        return indices;
    }
    
    // The path storing the final answer
    static List<Step> path;

    static String[][] rules;
    
    // Store a list of all failed cases, a String in the format of state of String+step
    static Set<String> failed;
    
    static String end;
    
    // External flag to stop our recursion stack
    static boolean stop;
    
    // Finds the first correct path given an initial String and amount of steps
    private static void check(String initial, int steps, List<Step> c) {
        if (stop) // Clear recursion stack by returning if flag is true
            return;

        if (steps == 0) { // Base case; if we used up all our steps
            if (c.get(c.size() - 1).result.equals(end)) { // If we found a correct path, i.e. last step = result
                stop = true; // Flag to clear the recursion stack
                path = new ArrayList<>(c); // Save the path
                return;
            }
            
            // No correct path was found
            
            // Save this as a failed case
            failed.add(initial + steps);
            
            c.remove(c.size() - 1); // Remove the last step from the current path, so we have room to try the next rule
            return;
        }
        
        for (int i = 0; i < 3; i++) { // Check each rule
            // Get all the indices where the rule can be applied
            // Empty if cannot apply the rule
            List<Integer> occurrences = getOcurrencesIndices(initial, rules[i][0]);

            for (int j : occurrences) { // Apply rule to each index where the rule can be applied
                String result = apply(initial, rules[i][0], rules[i][1], j); // Get the result

                if (!failed.contains(result + (steps - 1))) { // Continue only if the next step is not a failed case
                    c.add(new Step(i + 1, j + 1, result)); // Add the step to the path

                    check(result, steps - 1, c); // Recurse again until all steps are used up
                }
            }
        }
        
        // If we went through every rule but still couldn't find a match...
        
        // Save this as a failed case
        failed.add(initial + steps);

        // Backtrack by removing the last element from the current path in order to make room for another
        // as the same time as the function pops off the stack
        if (c.size() > 0)
            c.remove(c.size() - 1);
    }
    
    // Given a String, replace substring A with substring B at given index
    public static String apply(String initial, String a, String b, int index) {
        return initial.substring(0, index) + b + initial.substring(index + a.length());
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        rules = new String[3][2];
        failed = new HashSet<>();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                rules[i][j] = scan.next();
            }
        }
        
        int steps = scan.nextInt();
        String initial = scan.next();
        
        end = scan.next();
        
        check(initial, steps, new ArrayList<>());
        
        for (Step step : path) {
            System.out.println(step.rule + " " + step.index + " " + step.result);
        }
    }
    
}