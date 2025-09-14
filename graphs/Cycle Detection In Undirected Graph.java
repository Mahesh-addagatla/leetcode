import java.util.*;
public class Solution {
    public static boolean detectCycle(int cur,int par,int[] vis,ArrayList<Integer>[] adj){
        vis[cur] = 1;
        for(int it : adj[cur]){
            if(vis[it]!=1){
            if(detectCycle(it,cur,vis,adj)){
                return true;
            }
            }
            else if(it!=par){
                return true;
            }

        }
        return false;
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        int[] vis = new int[n+1];
        Arrays.fill(vis,0);
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++) adj[i]=new ArrayList<>();
        for(int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean isTrue = false;
        for(int i=1;i<=n;i++){
            if(vis[i]!=1){
                isTrue = detectCycle(i,-1,vis,adj);
            }
            if(isTrue)break;
        }
        if(isTrue)return "Yes";
        return "No";
    }
    
}
