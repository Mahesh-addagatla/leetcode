class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            int pr=prices[i]-mini;
            profit=Math.max(profit,pr);
            mini=Math.min(mini,prices[i]);
        }
        return profit;
    }
}
