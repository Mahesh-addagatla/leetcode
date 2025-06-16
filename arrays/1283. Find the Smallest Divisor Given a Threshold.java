class Solution {
    public boolean total(int[] nums,int div,int t,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double)nums[i]/div);
        }
        if(sum<=t)return true;
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        // int mini=Integer.MAX_VALUE;
        int maxi=0;
        if(threshold < n) return -1;
        for(int i=0;i<n;i++){
            // mini= Math.min(mini,nums[i]);
            maxi=Math.max(maxi,nums[i]);
        }
        int low=1;
        while(low<=maxi){
            int mid = (low+maxi)/2;
            if(total(nums,mid,threshold,n)){
                maxi=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
