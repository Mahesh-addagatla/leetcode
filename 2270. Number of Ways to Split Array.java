class Solution {
    public int waysToSplitArray(int[] nums) {
        int rs = 0;
        int ls = 0;
        for(int num:nums){
            rs+=num;
        }
        int validsplits=0;
        for(int i=0;i<nums.length-1;i++){
            ls+=nums[i];
            rs-=nums[i];
            if(ls >= rs){
                validsplits++;
            }
        }
        return validsplits;
    }
}
