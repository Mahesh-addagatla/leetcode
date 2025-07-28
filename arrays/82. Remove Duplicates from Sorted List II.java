class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        for(int i=2;i<nums.length;i++){
            if(nums[k-2]!=nums[i]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
