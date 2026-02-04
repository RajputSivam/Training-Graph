import java.util.*;
import java.util.Scanner;

///WAP to create ADjacency Matric of Graph
/// 
/// 
public class de
{
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
        boolean [] visited=new boolean[V];
        ArrayList<Integer> res=BFS( adj, visited, 0);
        System.out.println(res);
    }
    private static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.offer(src);
            
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans.add(node);
                
            for (int adjNode : adj.get(node))
            {
                if(!visited[adjNode])
                {
                    visited[adjNode] = true;
                    q.offer(adjNode);
				}
			}
        }
        return ans;
	}
}
// 3
// 4
// 0 1
// 2 3
// 2 1
// [0, 1]