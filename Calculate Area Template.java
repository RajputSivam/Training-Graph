class Solution {
    static int[] dr = {-1, 1, 0, 0}; // up, down, left, right
    static int[] dc = {0, 0, -1, 1};
    static int rowL;
    static int colL;
    public int maxAreaOfIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean[][] vis = new boolean[rowL][colL];

        int a = 0; 
        for(int i=0;i<rowL;i++)
        {
            for(int j=0;j<colL;j++)
            if( vis[i][j]==false && grid[i][j]==1)
            {
                a=Math.max(a,dfs(i,j,vis,grid) );
            }
        }
        return a;
        
    }
    private static int dfs(int r, int c, boolean[][] visited, int[][] grid) {
        // edge clase
        
        if (r < 0 || c < 0 || r >= rowL || c >= colL || grid[r][c] == 0) {
            return 0;
        }

        if (visited[r][c]==true) {
            return 0;
        }

        int area = 1;

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            
            area =area+ dfs(r + dr[i], c + dc[i], visited, grid);
        }
        return area;
    }
}