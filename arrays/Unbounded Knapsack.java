import java.util.*;
public class Solution {
    public static int maxProfit(int ind,int wt,int[] profit,int[] weight,int[][] dp){
        if(ind==0){
            return ((int)wt/weight[0])*profit[0];
        }
        if(dp[ind][wt]!=-1)return dp[ind][wt];
        int notTake = 0 + maxProfit(ind-1,wt,profit,weight,dp);
        int take = 0;
        if(weight[ind]<=wt){
            take = profit[ind] + maxProfit(ind,wt-weight[ind],profit,weight,dp);
        }
        return dp[ind][wt] = Math.max(take,notTake);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxProfit(n-1,w,profit,weight,dp);
    }
}
