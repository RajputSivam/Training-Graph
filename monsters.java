import java.io.*;
import java.util.*;

public class monsters {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        boolean[][] visM = new boolean[n][m];
        boolean[][] visP = new boolean[n][m];  // visited
        char[][] parent = new char[n][m];
        int[][] disM = new int[n][m];
        int[][] disP = new int[n][m];
        for (int[] row : disM) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int[] row : disP) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> mQ = new LinkedList<>();
        Queue<int[]> mP = new LinkedList<>();

        int pr = 0, pc = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'M') {
                    mQ.offer(new int[]{i, j});
                    disM[i][j] = 0;
                    visM[i][j] = true;
                }
                if (grid[i][j] == 'A') {
                    pr = i;
                    pc = j;
                    disP[i][j] = 0;
                    visP[i][j] = true;
                    mP.offer(new int[]{i, j});
                }
            }
        }

        // update monster distance to neighbour cells
        while (!mQ.isEmpty()) {
            int[] curr = mQ.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = disM[r][c];
            // isvalid

            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];

                if (nR >= 0 && nC >= 0 && nR < n && nC < m && !visM[nR][nC] && grid[nR][nC] == '.' && 1 + dis < disM[nR][nC]) {
                    disM[nR][nC] = 1 + dis;
                    visM[nR][nC] = true;
                    mQ.offer(new int[]{nR, nC});
                }
            }
        }

        //  update player distance 
        int er = -1, ec = -1;
        while (!mP.isEmpty()) {
            int[] curr = mP.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = disP[r][c];

            if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                er = r;
                ec = c;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                char distance = dir[i];

                if (nR >= 0 && nC >= 0 && nR < n && nC < m && !visP[nR][nC] && grid[nR][nC] == '.' && 1 + dis < disM[nR][nC]) {
                    visP[nR][nC] = true;
                    disP[nR][nC] = 1 + dis;

                    mP.offer(new int[]{nR, nC});
                    parent[nR][nC] = distance;
                }
            }

        }
        ArrayList<Character> path = new ArrayList<>();
        int i = er, j = ec;
        if (er == -1) {
            System.out.println("NO");
            return;
        }

        while (i != pr || j != pc) {
            path.add(parent[i][j]);
            if (parent[i][j] == 'U') {
                i++;
            } else if (parent[i][j] == 'D') {
                i--;
            } else if (parent[i][j] == 'L') {
                j++;
            } else if (parent[i][j] == 'R') {
                j--;
            }
        }

        Collections.reverse(path);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pathL = path.size();
        bw.write("YES" + "\n");
        bw.write(pathL + "\n");
        for (int k = 0; k < pathL; k++) {
            bw.write(path.get(k));
        }
        bw.flush();
        return;
    }

}