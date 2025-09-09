class Solution {
    static void dfs(int i,ArrayList<ArrayList<Integer>> adjLi,int[] vis){
        vis[i] = 1;
        for(int it: adjLi.get(i)){
            if(vis[it]!=1){
                dfs(it,adjLi,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjLi = new ArrayList<>();
        int n = isConnected.length;
        // System.out.println(n);
        for(int i=0;i<n;i++){
            adjLi.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjLi.get(i).add(j);
                    adjLi.get(j).add(i);
                }
            }
            // System.out.println(adjLi.get(i));
        }
        int c = 0;
        int[] vis = new int[n+1];
        Arrays.fill(vis,0);
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfs(i,adjLi,vis);
                c++;
            }
        }
        return c;
    }
}