class Solution {
    public int helper(int[] nums,int start,int end){
        int cur=0,prev=0;
        for(int i=start;i<=end;i++){
            int temp = cur;
            cur = Math.max(prev+nums[i],cur);
            prev = temp;
        }
        return cur;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1)return nums[0];
        return Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
}
