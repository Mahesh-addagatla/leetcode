class Solution {
    public static boolean dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st) {
        vis[node] = 1;
        for(int nei : adj.get(node)){
            if(vis[nei]==1)return false;
            if(vis[nei]==0){
                if(!dfs(nei,vis,adj,st)){
                    return false;
                }
            }
        }
        vis[node]=2;
        st.push(node);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // int m=prerequisites.length;
        // int n = prerequisites[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int u=pre[0],v=pre[1];
            adj.get(v).add(u);
        }
        int[] vis = new int[numCourses];
        int[] res = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(i,vis,adj,st)){
                    return new int[]{};
                }
            }
        }

        int idx =0;
        while(!st.isEmpty()){
            res[idx++]=st.pop();
        }
        return res;
    }
}
