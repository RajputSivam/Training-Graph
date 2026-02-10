public class er
{
    // Note
    // Truth first (important)
    // 👉 Undirected graphs do NOT have indegree and outdegree.
    // Those terms only exist for directed graphs.
    // In an undirected graph, an edge has no direction, so you only talk about degree.
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt();
        int V=sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>() );
        }

        for(int i=0;i<E;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
        }
        //Calculte Indegree
        int id=0;
        int [] indeg=new int[V];
        int [] outdeg=new int[V];
        for(int u=0;u<V;u++)
        {
            outdeg[u]=adj.get(u).size();
            for(int v:adj.get(u) )
            {
                indeg[v]++;
            }
        } 
        
    }
           
}