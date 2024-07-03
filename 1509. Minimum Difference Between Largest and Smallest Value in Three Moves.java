class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        if(n<=4){
            return 0;
        }
        Arrays.sort(nums);
        int min=nums[n-1]-nums[0];
        for(int i=0;i<=3;i++){
            min=Math.min(min,nums[n-(3-i)-1]-nums[i]);
        }
        return min;
    }
}
