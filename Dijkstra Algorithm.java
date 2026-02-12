class Solution {
    class Pair
    {
        int node;
        int dis;
        public Pair(int node,int dis)
        {
            this.node=node;
            this.dis=dis;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        int [] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>() );
        }
        for(int []edge:edges )
        {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            //undirected
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        distance[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> Integer.compare(a.dis,b.dis));
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty() )
        {
            Pair curr=pq.poll();
            int u=curr.node;
            int d=curr.dis;
            
            if( d>distance[u] ) continue;//most important problem,decrese key by lazy deletion
            for(Pair p:adj.get(u) )
            {
                int v=p.node;
                int costu_V= p.dis;
                if( distance[v]>distance[u]+costu_V  )
                {
                    distance[v]=distance[u]+costu_V;
                    pq.offer(new Pair(v,distance[v] ));
                }
            }
        }
        return distance;
        
    }
}







