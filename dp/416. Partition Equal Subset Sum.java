class Solution {
    public boolean f(int ind,int k,int[] nums,Boolean[][] dp){
        if(k==0)return true;
        if(ind == 0)return nums[0]==k;
        if(dp[ind][k]!=null)return dp[ind][k];
        boolean nottake = f(ind-1,k,nums,dp);
        boolean take = false;
        if(nums[ind]<=k)take = f(ind-1,k-nums[ind],nums,dp);
        return dp[ind][k] = nottake||take;
    }
    public boolean canPartition(int[] nums) {
        int sum =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        else{
            int target = sum/2;
            boolean[][] dp = new boolean[n][target+1]; 
            for(int i=0;i<n;i++){
                dp[i][0] = true;
            }
            if(nums[0]<=target)dp[0][nums[0]]= true;
            for(int i=1;i<n;i++){
                for(int k=1;k<=target;k++){
                    boolean nottake = dp[i-1][k];
                    boolean take = false;
                    if(nums[i]<=k){
                        take = dp[i-1][k-nums[i]];
                    }
                    dp[i][k] = take||nottake;
                }
            }
            return dp[n-1][target];
        }
    }
}
