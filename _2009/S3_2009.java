package _2009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * CCC 2019, S3
 * @author Kenneth Tran
 */
public class S3_2009 {
    
    // Unweighted, bidirectional graph
    public static class Graph {
        
        // Adjacency list
        final HashMap<Integer, Set<Integer>> adj;
        
        public Graph() {
            adj = new HashMap<>();
        }
        
        public void addEdge(int p, int q) {
            if (!adj.containsKey(p))
                adj.put(p, new HashSet<>());
            if (!adj.containsKey(q))
                adj.put(q, new HashSet<>());
            
            adj.get(p).add(q);
            adj.get(q).add(p);
        }
        
        public void removeEdge(int p, int q) {
            Set<Integer> v1 = adj.get(p);
            Set<Integer> v2 = adj.get(q);
            
            if (v1 != null)
                v1.remove(q);
            if (v2 != null)
                v2.remove(p);
        }
        
        // BFS starting from the source
        public int getShortestPath(int src, int dest) {
            int V = adj.size();
            
            // dist[i] holds the distance from the source to vertex i
            int dist[] = new int[V + 1];
            
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V + 1];
            
            visited[src] = true;
            queue.add(src);
            
            while (!queue.isEmpty()) {
                int i = queue.poll();
                
                for (int j : adj.get(i)) {
                    if (!visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                        
                        dist[j] = dist[i] + 1;
                        
                        if (j == dest)
                            return dist[dest];
                    }
                }
            }
            
            return -1;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Graph graph = new Graph();
        
        graph.addEdge(2, 6);
        graph.addEdge(1, 6);
        graph.addEdge(7, 6);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(3, 15);
        graph.addEdge(15, 13);
        graph.addEdge(13, 14);
        graph.addEdge(13, 12);
        graph.addEdge(12, 9);
        graph.addEdge(12, 11);
        graph.addEdge(11, 10);
        graph.addEdge(10, 9);
        graph.addEdge(9, 8);
        graph.addEdge(8, 7);
        graph.addEdge(16, 17);
        graph.addEdge(16, 18);
        graph.addEdge(17, 18);

        List<String> cmds = new ArrayList<>();
        
        String c = br.readLine();
        
        while (!c.equals("q")) {
            cmds.add(c);
            c = br.readLine();
        }
        
        for (String cmd : cmds) {
            String[] arr = cmd.split(" ");

            switch (arr[0]) {
                case "i":
                    graph.addEdge(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    break;
                case "d":
                    graph.removeEdge(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    break;
                case "n":
                    System.out.println(graph.adj.get(Integer.parseInt(arr[1])).size());
                    break;
                case "f":
                    int x = Integer.parseInt(arr[1]);
                    
                    Set<Integer> overlap = new HashSet<>();
                    
                    int count = 0;
                    
                    // Loop through friends of x
                    for (int i : graph.adj.get(x)) {
                        // Loop through friends of friends of x
                        for (int j : graph.adj.get(i)) {
                            // Count if j is not x, j is not a friend of x, and if j wasn't already counted before
                            if (j != x && !graph.adj.get(x).contains(j) && !overlap.contains(j)) {
                                overlap.add(j);
                                count++;
                            }
                        }
                    }
                    
                    System.out.println(count);
                    
                    break;
                case "s":
                    int s = graph.getShortestPath(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                    
                    if (s == -1)
                        System.out.println("Not connected");
                    else
                        System.out.println(s);
                    break;
                default:
                    br.close();
                    return;
            }
        }
    }
    
}