package _2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * CCC 2012, S4
 * @author Kenneth Tran
 */
public class S4_2012 {

    public static class Config {
    
        // Our config is a wrapper for an array of integer stacks
        Stack<Integer>[] arr;
        
        public Config(Stack<Integer>[] arr) {
            this.arr = arr;
        }
        
        // From this current configuration, get a list of the next possible configurations by trying
        // every legal move
        private List<Config> getNextMoves() {
            List<Config> moves = new ArrayList<>();
            
            // Loop through each index of the array, and try to move the coin at the top of each stack to another stack in an adjacent index
            for (int i = 0; i < arr.length; i++) {
                for (int j = i - 1; j <= i + 1; j++) {
                    // If the adjacent stack (j) is out of bounds or if the first stack (i) is empty, then skip
                    if (j < 0 || j == i || j >= arr.length || arr[i].isEmpty())
                        continue;

                    // Can only make a move if the adjacent stack is empty
                    // or if the coin at the top of the first stack is of lower value than the coin at the top of the adjacent stack
                    // i.e. Cannot place a higher-value coin on top of a lower-value coin
                    if (arr[j].isEmpty() || arr[i].peek() < arr[j].peek()) {
                        // Need to do a deep copy to make a new integer stack array
                        Stack<Integer>[] c = deepCopy(arr);

                        c[j].push(c[i].pop());
                        Config next = new Config(c);
                        moves.add(next);
                    }
                }
            }

            return moves;
        }
            
        // Check if this config is in order
        public boolean inOrder() {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].isEmpty() || arr[i + 1].isEmpty() || arr[i].peek() > arr[i + 1].peek()) {
                    return false;
                }
            }

            return true;
        }
        
        // Override equals and hashCode so that the Hash collections can properly compare Config objects
        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Config))
                return false;
            
            return Arrays.toString(((Config) o).arr).equals(Arrays.toString(this.arr));
        }

        // Override the hashCode so that every config shares the same hash code even if they
        // are different instances of the Config class
        //
        // e.g. A config of [ (2) | (31) | ( ) | (4) | (5) ] would have a hash code of 10134
        @Override
        public int hashCode() {
            int[] h = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                for (int j : arr[i]) {
                    h[j - 1] = i;
                }
            }

            String hash = "";
            
            for (int i : h)
                hash += i;
            
            return Integer.parseInt(hash);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Config> configs = new ArrayList<>();
        
        String line1, line2;
        
        // Read input
        while (true) {
            line1 = br.readLine();
            
            if (line1.equals("0"))
                break;
            
            line2 = br.readLine();

            int n = Integer.parseInt(line1);
            
            String[] t = line2.split(" ");
            Stack<Integer>[] c = new Stack[n];
            
            for (int i = 0; i < n; i++) {
                c[i] = new Stack<>();
                c[i].push(Integer.parseInt(t[i]));
            }
            
            configs.add(new Config(c));
        }
        
        for (Config config : configs) {
            solve(config);
        }
    }
    
    // Breadth first search to solve a given config
    public static void solve(Config config) {
        // If already in order, no need to do a search
        if (config.inOrder()) {
            System.out.println(0);
            return;
        }
        
        // Use a queue and visited set for our BFS
        Queue<Config> queue = new LinkedList<>();
        HashSet<Config> visited = new HashSet<>();
        
        // Keep track of our moves with this HashMap
        // The value at a key is the moves it took to reach that config, starting from the initial config
        HashMap<Config, Integer> dist = new HashMap<>();
        
        // Start the queue with the first config
        queue.add(config);
        visited.add(config);

        while (!queue.isEmpty()) {
            Config curr = queue.poll();

            // Initialize in the dist map
            if (!dist.containsKey(curr))
                dist.put(curr, 0);

            // Loop through the set of next possible moves/configs
            for (Config next : curr.getNextMoves()) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);

                    // Keep track of the distance (moves) from the initial config to the current config
                    dist.put(next, dist.get(curr) + 1);

                    // Stop once we found a config that is in order, and print out the moves it took to reach this config
                    if (next.inOrder()) {
                        System.out.println(dist.get(next));
                        return;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
    
    // Perform a deep copy of an array of stacks of integers
    private static Stack<Integer>[] deepCopy(Stack<Integer>[] c) {
        Stack<Integer>[] copy = new Stack[c.length];
        
        for (int i = 0; i < c.length; i++) {
            Stack<Integer> old = c[i];
            Stack<Integer> n = new Stack<>();
            
            if (!old.isEmpty()) {
                for (Integer j : old) {
                    n.push(j);
                }
            }
            
            copy[i] = n;
        }
        
        return copy;
    }
    
}