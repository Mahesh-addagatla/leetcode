class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0] = 0;
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<=k;j++){
                dp[0][i][j] = 0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==1){
                        dp[i][buy][cap] = Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
                    }
                    else dp[i][buy][cap] = Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
                }
            }
        }
        return dp[0][1][k];
    }
}
