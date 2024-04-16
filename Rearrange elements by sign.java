class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int po=0,ne=1;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ans[ne]=nums[i];
                ne+=2;
            }
            else{
                ans[po]=nums[i];
                po+=2;
            }
        }
        return ans;
    }
}
