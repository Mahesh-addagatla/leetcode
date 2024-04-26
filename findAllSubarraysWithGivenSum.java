class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        int n=nums.length;
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum-k;
            count+=hs.getOrDefault(rem,0);
            hs.put(sum,hs.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
