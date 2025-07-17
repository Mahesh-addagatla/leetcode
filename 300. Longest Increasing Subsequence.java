class Solution {
    public int sub(int cur_idx,int prev_idx,int[] nums,int n,int[][] dp){
        if(cur_idx == n){
            return 0;
        }
        if(dp[cur_idx][prev_idx+1]!=-1)return dp[cur_idx][prev_idx+1];
        int len = sub(cur_idx+1,prev_idx,nums,n,dp);
        if(prev_idx == -1 || nums[prev_idx] < nums[cur_idx]){
            len = Math.max(len,1+sub(cur_idx+1,cur_idx,nums,n,dp));
        }
        return dp[cur_idx][prev_idx+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sub(0,-1,nums,n,dp);
    }
}
