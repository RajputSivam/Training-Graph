import java.io.*;
import java.util.*;

public class spp{

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of courses (V)
        int m = Integer.parseInt(st.nextToken()); // number of prerequisites (E)

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(v).add(u); // v -> u because v must be taken before u
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n]; // track recursion stack
        boolean canFinish = true;

        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                if (dfs(i, visited, pathVisited, adj))
                {
                    canFinish = false;
                    break;
                }
            }
        }
        System.out.println(canFinish); // true if possible, false if cycle exists
    }

    // DFS function returns true if a cycle is detected
    public static boolean dfs(int node, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node))
        {
            if (!visited[neighbor])
            {
                if (dfs(neighbor, visited, pathVisited, adj)) return true;
            }
            else if (pathVisited[neighbor])
            {
                // cycle detected
                return true;
            }
        }
        pathVisited[node] = false; // backtrack
        return false;
    }
}
