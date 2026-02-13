import java.util.*;
import java.io.*;

public class de
{
    static class Pair
    {
        int node;
        long wt;
        public Pair(int node,long wt)
        {
            this.node=node;
            this.wt=wt;
        }
    }
    static int MOD=1000_000_007;
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//to take fast input
        StringTokenizer st=new StringTokenizer(br.readLine() );
        int n=Integer.parseInt( st.nextToken());
        int m=Integer.parseInt( st.nextToken());

        int V=n;
        int E=m;
        //create Adjacency Matrix
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=V;i++)
        {
            adj.add(new ArrayList<Pair>() );
        }
        for(int i=0;i<E;i++)
        {
            st=new StringTokenizer(br.readLine() );
            int u=Integer.parseInt( st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long wt=Long.parseLong( st.nextToken() );
            adj.get(u).add(new Pair(v,wt));
            // adj.get(v).add(new Pair(u,wt));
        }
        long []dis=new long[V+1];
        Arrays.fill(dis,Long.MAX_VALUE );
        dis[1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));
        long []ways=new long[V+1];
        ways[1]=1;

        int []min=new int[V+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[1]=0;
        int []max=new int[V+1];
        Arrays.fill(max,Integer.MIN_VALUE);
        max[1]=0;

        pq.offer(new Pair(1,0));
        while(!pq.isEmpty() )
        {
            Pair cur=pq.poll();
            int u=cur.node;
            
            if( cur.wt>dis[u] ) continue;
            for(Pair P:adj.get(u) )
            {
                int v=P.node;
                long weight=P.wt;
                if( dis[v]<dis[u]+weight) continue;
                if( dis[v]>dis[u]+weight )
                {
                    dis[v]=dis[u]+weight;
                    ways[v]=ways[u];
                    pq.offer(new Pair(v,dis[v] ));

                    min[v]=min[u]+1;
                    max[v]=max[u]+1;

                }
                else if( dis[v]==dis[u]+weight )
                {
                    ways[v]=(ways[v]+ways[u])%MOD;

                    min[v]=Math.min(min[v],min[u]+1);
                    max[v]=Math.max(max[v],max[u]+1);
                }

            }
        }
        System.out.println( dis[V]+" "+ways[V]+" "+min[V]+" "+max[V]);
    } 
}
// what is the minimum price of such a route?
// how many minimum-price routes are there? (modulo 10^9+7)-
// what is the minimum number of flights in a minimum-price route?
// what is the maximum number of flights in a minimum-price route?