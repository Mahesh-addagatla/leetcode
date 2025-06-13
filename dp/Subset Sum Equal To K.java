import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean f(int ind,int k,int[] arr,Boolean[][] dp){
        if(k == 0)return true;
        if(ind == 0){
            return arr[0]==k;
        }
        if(dp[ind][k]!=null)return dp[ind][k];
        boolean notTake = f(ind-1,k,arr,dp);
        boolean take = false;
        if(k>=arr[ind])take = f(ind-1,k-arr[ind],arr,dp);
        return dp[ind][k] = notTake || take;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] cur = new boolean[k+1];
            cur[0] = true;
            for(int j=1;j<=k;j++){
                boolean notTake = prev[j];
                boolean take = false;
                if(j>=arr[i])take = prev[j-arr[i]];
                cur[j] = notTake || take;
            }
            prev = cur;
        }
        return prev[k];
    }
}
