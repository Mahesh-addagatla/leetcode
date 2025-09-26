class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int c=0;
        for(int i=n-1;i>1;i--){
            int l =0;
            int r=i-1;
            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    c+=r-l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return c;
    }
}
