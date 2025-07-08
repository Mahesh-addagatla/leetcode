class Solution {
    static int profit =0;
    public int maxP(int i,int buy,int[] prices,int n,int[][] dp){
        if(i==n)return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        if(buy==1) profit = Math.max(-prices[i]+maxP(i+1,0,prices,n,dp),maxP(i+1,1,prices,n,dp));
        else{
            profit = Math.max(prices[i]+maxP(i+1,1,prices,n,dp),maxP(i+1,0,prices,n,dp));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+1][2];
        // dp[n][0]=dp[n][1] = 0;
        int curBuy,curNotBuy,aheadBuy,aheadNotBuy;
        aheadBuy=aheadNotBuy=0;
        for(int i=n-1;i>=0;i--){
                curBuy = Math.max(-prices[i]+aheadNotBuy,aheadBuy);
                curNotBuy = Math.max(prices[i]+aheadBuy,aheadNotBuy);
                aheadBuy=curBuy;
                aheadNotBuy = curNotBuy;
        }
        return aheadBuy;
    }
}
