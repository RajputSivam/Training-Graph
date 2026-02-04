class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges)
    {
        int E=edges.length;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            res.add( new ArrayList<Integer>() );
        }
        for(int i=0;i<E;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            res.get(u).add(v);
            res.get(v).add(u);
        }
        ArrayList<ArrayList<Integer>> rm=new ArrayList<>();
        boolean [] vis=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if (vis[i]) continue;
            ArrayList<Integer> ar=new ArrayList<>();
            dfs(i,res,ar,vis);
            rm.add(ar);
        } 
        return rm;
    }
    public static void dfs(int src,ArrayList<ArrayList<Integer>> res,List<Integer> ar,boolean [] vis)
    {
        vis[src]=true;
        ar.add(src);
        for(int adj:res.get(src) )
        {
            if( vis[adj]==false)
            {
                
                dfs(adj,res,ar,vis);
            }
        }
        
    }
}





// class Solution {
//     public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
//         // code here
//         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//         for(int i=0; i<V; i++){
//             list.add(new ArrayList<>());
//         }

//         for(int[] e:edges) {
//             int u=e[0];
//             int v=e[1];

//             list.get(u).add(v);
//             list.get(v).add(u);
//         }
//         boolean[] vis = new boolean[V];
        
//         for(int i=0; i<V; i++){
//             if(!vis[i]){
//                 ArrayList<Integer> ans = new ArrayList<>();
//                 ans = dfs(list, i, vis, ans);
                
//                 res.add(ans);
//             }
//         }
//         return res;
//     }
//     public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> list, int src, boolean[] vis, ArrayList<Integer> res) {
//         res.add(src);
//         vis[src] = true;
//         for(int node:list.get(src)){
//             if(!vis[node]){
//                 dfs(list, node, vis, res);
//             }
//         }
//         return res;
//     }
// }
