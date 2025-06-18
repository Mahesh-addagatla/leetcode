class Solution {
    public int f(int[] coins,int amount,int ind,int[][] dp){
        if(ind == 0){
            if(amount%coins[0]==0)return amount/coins[0];
            else return (int)1e9;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];
        int nottake = 0 + f(coins,amount,ind-1,dp);
        int take = (int)1e9;
        if(coins[ind]<=amount) take = 1+f(coins,amount-coins[ind],ind,dp);
        return dp[ind][amount]=Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)dp[0][i] = i/coins[0];
            else dp[0][i] = (int)1e9; 
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int nottake = 0 + dp[i-1][t];
                int take = (int)1e9;
                if(coins[i]<=t) take = 1+dp[i][t-coins[i]];
                dp[i][t]=Math.min(take,nottake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans>=1e9)return -1;
        return ans;
    }
}
