import java.util.*;

public class Solution {

    // Function to check bipartite using BFS
    private boolean check(int start, int V,
                          ArrayList<ArrayList<Integer>> adj,
                          int color[]) {

        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        color[start] = 0;   // give first color

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int it : adj.get(node)) {

                // If adjacent node is not colored
                if (color[it] == -1) {
                    color[it] = 1 - color[node]; // opposite color
                    q.add(it);
                }

                // If adjacent node has same color
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Main function to check bipartite
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

        int color[] = new int[V];
        Arrays.fill(color, -1);  // -1 means not colored

        // Check for all components
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (check(i, V, adj, color) == false)
                    return false;
            }
        }

        return true;
    }


    // Driver Code for Testing
    public static void main(String[] args) {

        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Example graph
        // 0 - 1
        // |   |
        // 3 - 2

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        Solution obj = new Solution();

        if (obj.isBipartite(V, adj))
            System.out.println("Graph is Bipartite");
        else
            System.out.println("Graph is Not Bipartite");
    }
}
