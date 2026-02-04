import java.util.*;
import java.util.Scanner;

///WAP to create ADjacency Matric of Graph
/// 
/// 
public class dfs
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
        ArrayList<Integer> res=new ArrayList<>();
        dfs( 0, visited, adj,res);
        System.out.println(res);
    }
    public static void dfs(int src,boolean [] visited,ArrayList<ArrayList<Integer>> adj,List<Integer> res)
    {
        res.add(src);
        visited[src]=true;
        for(int adjNode:adj.get(src))
        {
            if( visited[adjNode]==false)
            {
                dfs(adjNode,visited,adj,res);
            }
        }
    } 
}
// 3
// 4
// 0 1
// 2 3
// 2 1
// [0, 1]