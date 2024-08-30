class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k!=0){
            int[] ans = help(nums);
            int min = ans[0];
            int mi = ans[1];
            min *= multiplier;
            nums[mi] = min;
            k--;
        }
        return nums;
    }
    public int[] help(int[] nums){
        int n = nums.length;
        int min = nums[0],mi = 0;
        for(int i=1;i<n;i++){
            if(min > nums[i]){
                min = nums[i];
                mi = i;
            }
        }
        int[] arr = {min,mi};
        return arr;
    }
}
