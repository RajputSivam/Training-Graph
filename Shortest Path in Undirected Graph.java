class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        boolean[] visited = new boolean[V];
        visited[src] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int nextNode : adj.get(curr))
            {
                if (1 + distance[curr] < distance[nextNode])
                {
                    distance[nextNode] = 1 + distance[curr];
                }
                
                if (!visited[nextNode])
                {
                    visited[nextNode] = true;
                    q.offer(nextNode);
                }
            }
        }
        
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }
        
        return distance;
    }

