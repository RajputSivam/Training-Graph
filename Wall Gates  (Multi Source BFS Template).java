import java.util.LinkedList;
import java.util.Queue;

public class GraphListRrep {

    public static void main(String[] args) {
        // inf path
        // -1 (wall)
        // 0 gate
        int [][]rooms = { {2147483647, -1, 0, 2147483647}, 
                        {2147483647, 2147483647, 2147483647, -1},
                        {2147483647, -1, 2147483647, -1},
                        {0, -1, 2147483647, 2147483647}};

        chr( rooms);
        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[0].length;j++)
            {
                System.out.print(rooms[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int [] dr={-1,1,0,0};
    static int [] dc={0,0,-1,1};
    static int rowL;
    static int colL;
    static class Pair
    {
        int r;
        int c;
        public Pair(int r,int c)
        {
            this.r=r;
            this.c=c;
        }
    }
    public static void chr( int [][]grid)
    {
        Queue<Pair> q=new LinkedList<Pair>();
        rowL=grid.length;
        colL=grid[0].length;
        
        for(int i=0;i<rowL;i++)
        {
            for(int j=0;j<colL;j++)
            {
                if( grid[i][j]==0)
                {
                    q.offer(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty())
        {
            Pair cur=q.poll();
            int r=cur.r;
            int c=cur.c;
            for(int i=0;i<4;i++)//msg have min dis I believe
            {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if( nr>=0 && nc>=0 && nr<rowL && nc<colL && grid[nr][nc]==Integer.MAX_VALUE  )
                {
                    grid[nr][nc]=grid[r][c]+1;
                    q.offer(new Pair(nr, nc) );
                }
            }
            
            
        }
    }
}
   