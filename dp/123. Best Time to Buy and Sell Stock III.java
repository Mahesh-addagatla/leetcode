class Solution {
    public int f(int i,int buy,int cap,int[] prices,int n,int[][][] dp){
        if(cap==0)return 0;
        if(i==n)return 0;
        if(dp[i][buy][cap]!=-1)return dp[i][buy][cap];
        if(buy==1){
            return dp[i][buy][cap] = Math.max(-prices[i]+f(i+1,0,cap,prices,n,dp),f(i+1,1,cap,prices,n,dp));
        }
        return dp[i][buy][cap] = Math.max(prices[i]+f(i+1,1,cap-1,prices,n,dp),f(i+1,0,cap,prices,n,dp));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0]=0;
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                dp[n][i][j] = 0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<3;cap++){
                    if(buy==1){ 
                        dp[i][buy][cap] = Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                    }
                    else dp[i][buy][cap] = Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
                }
            }
        }
        return dp[0][1][2];
    }
}
