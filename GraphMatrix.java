import java.util.Scanner;

///WAP to create ADjacency Matric of Graph
public class GraphList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt();
        int V=sc.nextInt();

        int [][] matrix=new int[V+1][V+1];
        for(int i=0;i<E;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            matrix[u][v]=1;
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                System.out.print( matrix[i][j]);
            }
            System.out.println();
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