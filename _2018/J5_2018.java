package _2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * CCC 2018, J5
 * @author Kenneth Tran
 */
public class J5_2018 {
    
    public static class Page {
        
        int num;
        Set<Page> next;
        
        public Page(int num) {
            this.num = num;
            this.next = new HashSet<>();
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        // Key - page number
        // Value - page object node
        Map<Integer, Page> pages = new HashMap<>();
        
        // Create page nodes
        for (int i = 1; i <= N; i++) {
            Page page = new Page(i);
            pages.put(i, page);
        }
        
        // Link pages with given input
        for (int i = 1; i <= N; i++) {
            String[] x = br.readLine().split(" ");
            
            for (int j = 0; j < Integer.parseInt(x[0]); j++) {
                pages.get(i).next.add(pages.get(Integer.parseInt(x[j + 1])));
            }
        }
        
        System.out.println(allReachable(pages) ? "Y" : "N");
        System.out.println(shortestPath(pages));
    }
    
    // Check if all reachable using BFS
    public static boolean allReachable(Map<Integer, Page> pages) {
        boolean[] visited = new boolean[pages.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        int explored = 1;
        
        visited[1] = true;
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (Page next : pages.get(current).next) {
                if (!visited[next.num]) {
                    visited[next.num] = true;
                    queue.add(next.num);
                    
                    explored++;
                }
            }
        }
        
        // If the # of pages explored is equal to the total # of pages (N), then all are reachable
        return explored == pages.size();
    }
    
    // Shortest path using BFS
    public static int shortestPath(Map<Integer, Page> pages) {
        boolean[] visited = new boolean[pages.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        // Keep track of the dist from root
        int[] dist = new int[pages.size() + 1];
        
        visited[1] = true;
        queue.add(1);
        dist[1] = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // Stop once we reach a page that has no more children pages
            if (pages.get(current).next.isEmpty()) {
                return dist[current];
            }
            
            for (Page next : pages.get(current).next) {
                if (!visited[next.num]) {
                    visited[next.num] = true;
                    queue.add(next.num);
                    
                    dist[next.num] = dist[current] + 1;
                }
            }
        }
        
        return -1;
    }
    
}