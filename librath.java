import java.io.*;
import java.util.*;

public class librath {
    static int []dr = {-1,1,0,0};
    static int []dc = {0,0,-1,1};
    static char[]dir = {'U','D','L','R'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][]grid = new char[n][m];
        boolean [][]vis = new boolean[n][m];  // visited
        char [][]parent = new char[n][m]; // path tracking
        int sr=0,sc=0,er=0,ec=0;
        for(int i = 0 ; i < n ; i++)
        {
            String s = br.readLine();
            for(int j = 0 ; j < m;j++)
            {
                grid[i][j] = s.charAt(j);
                if(grid[i][j] == 'A')
                {
                    sr = i;
                    sc   = j;
                }
                if(grid[i][j] == 'B')
                {
                    er = i;
                    ec   = j;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        vis[sr][sc] = true;

        while(!q.isEmpty())
        {
            int []curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0 ; i < 4; i++)
            {
                int nR = r + dr[i];
                int nC = c + dc[i];
                char direction  = dir[i];

                if(nR >=0 && nC>=0 && nR < n && nC < m && !vis[nR][nC]  && grid[nR][nC]=='B')
                {
                    parent[nR][nC] = direction;
                    vis[nR][nC] = true;
                    break;
                }

                // valid
                if(nR >=0 && nC>=0 && nR < n && nC < m && !vis[nR][nC] && grid[nR][nC]=='.')
                {
                    vis[nR][nC] = true;
                    q.offer(new int[]{nR,nC});
                    parent[nR][nC] = direction;
                }
            }

        }
        if(vis[er][ec] == false)
        {
            System.out.println("NO");
            return;
        }

        ArrayList<Character>path = new ArrayList<>();
        int i = er,j=ec;

        while(i!=sr || j!=sc)
        {
            path.add(parent[i][j]);
            if(parent[i][j] == 'U')i++;
            else if(parent[i][j] == 'D')i--;
            else if(parent[i][j] == 'L')j++;
            else if(parent[i][j] == 'R')j--;
        }


        Collections.reverse(path);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pathL = path.size();
        bw.write("YES"+"\n");
        bw.write(pathL+"\n");
        for(int k = 0 ; k < pathL;k++)
        {
            bw.write(path.get(k));
        }
        bw.flush();
        return;
    }
}