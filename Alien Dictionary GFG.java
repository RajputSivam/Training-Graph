class Solution {
    public String findOrder(String[] words) {
        // code here
        
        int n = words.length;
       
        
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        
        for (int i = 0; i < 26; i++){
            adjlist.add(new ArrayList <>());
        }
        int[] indegree = new int[26];
        Arrays.fill(indegree,-1);
        
        
        for (String word : words){ //loop work n-1 time compare 2 element
        
            for (char ch : word.toCharArray()){
                
                if(indegree[ch - 'a'] == -1){
                    indegree[ch  - 'a'] = 0;
                }
                
            }
        }
        
        for (int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            if (word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            for (int k = 0; k < Math.min(word1.length() , word2.length()); k++){
                char u = word1.charAt(k);
                char v = word2.charAt(k);
                if (u!= v){
                    adjlist.get(u - 'a').add(v- 'a');
                    indegree[v-'a']++;
                    break;
                }
            }
        }
        
        int count =0 ;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        //bfs
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()){
            int node = q.poll();
            sb.append((char)(node + 'a'));
            for (int adj : adjlist.get(node)){
                indegree[adj]--;
                if(indegree[adj] == 0){
                    q.offer(adj);
                }
            }
        }
        
        for (int i = 0; i < 26; i++){
            if (indegree[i] > 0){
                count++;
            }
        }
        
        return count == 0 ? sb.toString() : "";
    }
}