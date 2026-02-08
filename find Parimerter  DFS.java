class Solution {
    static int[] dr={-1,1,0,0};
    static int []dc={0,0,-1,1};
    static int rowL;
    static int colL;
    public int islandPerimeter(int[][] grid)
    {
        rowL=grid.length;
        colL=grid[0].length;
        boolean [][]vis=new boolean [rowL][colL];
        int a=0;

        for(int i=0;i<rowL;i++)
        {
            for(int j=0;j<colL;j++)
            {
                if( grid[i][j]==1 && vis[i][j]==false)
                {
                    a=dfs(i,j,vis,grid);
                }
            }
        }
        return a;
    }
    public static int dfs(int r,int c,boolean [][]vis,int [][] grid)
    {
        if( r<0 || c<0 || r>rowL-1 || c>colL-1 || grid[r][c]==0)
        {
            return 1;
        }
        if( vis[r][c]==true)
        {
            return 0;
        }
        int pr=0;
        vis[r][c]=true;
        for(int i=0;i<4;i++)
        {
            pr=1+dfs(r+dr[i],c+dc[i],vis,grid);
        }
        return pr;

    }
}