[12:13, 09/02/2026] Shashank Puskar: import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BuildingRoads {

    static int rowL, colL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowL = Integer.parseInt(st.nextToken());
        colL = Integer.parseInt(st.nextToken());
        int[][] roads = new int[colL][2];

        for (int i = 0; i < colL; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> adj = adjList(roads, rowL);
        boolean[] visited = new boolean[rowL + 1];

        int components = 0;
        ArrayList<Integer> toConnect = new ArrayList<>();
        for (int i = 1; i <= rowL; i++) {
            if (!visited[i]) {
                bfs(i, adj, visited);
                components++;
                toConnect.add(i);
            }
        }

        System.out.println(components - 1);
        for (int i = 1; i < toConnect.size(); i++) {
            System.out.println(toConnect.get(i - 1) + " " + toConnect.get(i));
        }
    }

    public static void bfs(int idx, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> adjList(int[][] roads, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
