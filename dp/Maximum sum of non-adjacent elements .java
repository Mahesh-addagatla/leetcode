class Solution {
    // public int helper(int[] nums,int idx,int[] dp){
    //     if(idx < 0) return 0;
    //     // if(idx == 0)return dp[0] = nums[0];
    //     if(dp[idx] != -1)return dp[idx];
    //     int left = helper(nums,idx-1,dp);
    //     int right = helper(nums,idx-2,dp)+nums[idx];
    //     return dp[idx] = Math.max(left,right);
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return helper(nums,n-1,dp);

        int prev = 0;
        int cur = 0;
        for(int i= 0;i<n;i++){
            int temp = cur;
            cur = Math.max(prev + nums[i],cur);
            prev = temp;
        }
        return cur;
    }
}
