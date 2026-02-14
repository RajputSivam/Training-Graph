import java.io.*;
import java.util.*;

public class srr {
    static class  Pair
    { 
        int r;
        int c;
        public Pair(int r,int c)
        {
            this.r=r;
            this.c=c;
        }
    }
    static int []dr={-1,1,0,0};
    static int[]dc={0,0,-1,1};
    static int rowL;
    static int colL;
    static char [] dir={'U','D','L','R'};  
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st=new StringTokenizer(br.readLine() );

        int n=Integer.parseInt( st.nextToken() );
        int m=Integer.parseInt( st.nextToken() );
        int V=n;
        int E=m;
        rowL=V;
        colL=E;

        int sr=0;
        int sc=0;
        int er=0;
        int ec=0;
        char [][] grid=new char[rowL][colL];

        for(int i=0;i<V;i++)
        {
            String s=br.readLine();
            for(int j=0;j<s.length();j++)
            {
                //if( )
                grid[i][j]=s.charAt(j);
            }
        }
    

        int[][] pt=new int[rowL][colL];
        int [][]mt=new int[rowL][colL];

        for(int ar[]:pt )
        {
            Arrays.fill(ar,Integer.MAX_VALUE);
        }
        for(int ar[]:mt)
        {
            Arrays.fill(ar,Integer.MAX_VALUE);
        }

        boolean [][]vism=new boolean[rowL][colL];
        boolean [][]visp=new boolean[rowL][colL];
        char [][] parent=new char[rowL][colL];

        Queue<Pair> pq=new LinkedList<>();
        Queue<Pair> mq=new LinkedList<>();
        //m bfs
        for(int i=0;i<rowL;i++)
        {
            for(int j=0;j<colL;j++)
            {
                if( grid[i][j]=='M' && visp[i][j]==false)
                {
                    mt[i][j]=0;
                    vism[i][j]=true;
                    mq.offer(new Pair(i, j));
                }
            }
        }
        //p bfs
        int ppr=-1;
        int ppc=-1;
        for(int i=0;i<rowL;i++)
        {
            for(int j=0;j<colL;j++)
            {
                if( grid[i][j]=='A' && visp[i][j]==false)
                {
                    pt[i][j]=0;
                    visp[i][j]=true;
                    ppr=i;
                    ppc=j;
                    pq.offer(new Pair(i, j));
                }
            }
        }//if placer is present oo boundry
        if( ppr==0 || ppr==rowL-1 || ppc==0 || ppc==colL-1)
        {
            System.out.println("YES");
            System.out.println(0);
            return;
        }

        //mq
        while (!mq.isEmpty() )
        {
            Pair cur=mq.poll();
            int sri=cur.r;
            int sci=cur.c;
            int dis=mt[sri][sci];
            for(int i=0;i<4;i++)
            {
                int nr=sri+dr[i];
                int nc=sci+dc[i];
                if( nr>=0 && nc>=0 && nr<rowL && nc<colL && grid[nr][nc]!='#' &&  vism[nr][nc]==false && 1+dis<mt[nr][nc])
                {
                    mt[nr][nc]=1+dis;
                    vism[nr][nc]=true;
                    mq.offer(new Pair(nr,nc) );
                }
            }
        }
        //pq
        int err=-1;
        int ecc=-1;
        while (!pq.isEmpty() )
        {
            Pair cur=pq.poll();
            int sri=cur.r;
            int sci=cur.c;
            int dis=pt[sri][sci];
            for(int i=0;i<4;i++)
            {
                int nr=sri+dr[i];
                int nc=sci+dc[i];

                if( nr>=0 && nc>=0 && nr<rowL && nc<colL && grid[nr][nc]!='#'  &&  visp[nr][nc]==false && 1+dis<mt[nr][nc])
                {
                    if( ( nr==0 || nc==0 || nr==rowL-1 || nc==colL-1 ) && grid[nr][nc]!='#' )
                    {
                        err=nr;
                        ecc=nc;
                        parent[nr][nc]=dir[i];
                        visp[nr][nc]=true;
                        pq.clear();
                        break;
                    }
                    pt[nr][nc]=1+dis;
                    visp[nr][nc]=true;
                    parent[nr][nc]=dir[i];
                    pq.offer(new Pair(nr,nc) );
                }
            }
        }



        if( err==-1)
        {
            System.out.println("NO");
            return;
        }
    
      
        ArrayList<Character> ar=new ArrayList<>();
        int i=err;
        int j=ecc;
        
        while( i!=ppr || j!=ppc  )
        {
            char d=parent[i][j];
            if ( d==0)
            {
                break;
            }
            ar.add(parent[i][j] );
            if( parent[i][j]=='U' ) i++;
            else if( parent[i][j]=='D' ) i--;
            else if( parent[i][j]=='L' ) j++;
            else if( parent[i][j]=='R') j--;
        }
        System.out.println( "YES");
        System.out.println(ar.size() );
        Collections.reverse(ar);

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int k=0;k<ar.size();k++)
        {
            bw.write( ar.get(k));
        }
        bw.flush();
        return;
    }
   
}