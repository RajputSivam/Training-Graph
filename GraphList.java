import java.util.ArrayList;
import java.util.Scanner;

///WAP to create ADjacency Matric of Graph
public class GraphList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt();
        int V=sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>() );
        }

        for(int i=0;i<V;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
        }

        

        for (int i = 0; i < V; i++)
        {
            System.out.println(adj.get(i));
        }
            
    }
}
// 3
// 4
// 1 2
// 2 3
// 2 1
// 0000
// 0010
// 0101
// 0000