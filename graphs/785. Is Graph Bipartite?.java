class Solution {
    public static boolean dfs(int idx,int co,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[idx] = co;
        for(int it:adj.get(idx)){
            if(color[it]==-1){
                if(!dfs(it,1-co,color,adj))return false;
            }else if(color[it]==color[idx])return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(i,0,color,adj))return false;
            }
        }
        return true;
    }
}
