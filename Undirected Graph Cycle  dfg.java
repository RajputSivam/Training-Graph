class Solution {
    static class Pair{
        int node;
        int parent;
        public Pair(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        
        for (int i = 0; i < V; i++){
            adjlist.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++){
            if(vis[i] == false){
                if (bfs(i,vis,adjlist) == true){
                    return true;
                }
            }
            
        }
        return false;
        
        
        
        
    }
    
    public boolean bfs(int src ,boolean[] vis ,ArrayList<ArrayList<Integer>> adjlist){
        Queue<Pair> Q = new LinkedList<Pair>();
        vis[src] = true;
        Q.offer(new Pair(src,-1));
        
        while(!Q.isEmpty()){
            Pair curr = Q.poll();
            int node = curr.node;
            int parent = curr.parent;
            for (int adj : adjlist.get(node)){
                if (vis[adj] == false)
                {
                    vis[adj] = true;
                    Q.offer(new Pair(adj,node));
                }
                else{
                    if (parent != adj){
                        return true;
                    }
                }
                
            
            }
            
        }
        return false;
    }
}