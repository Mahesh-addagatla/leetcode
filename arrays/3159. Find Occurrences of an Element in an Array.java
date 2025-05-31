class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = queries.length; 
        int[] ans = new int[n];
        HashMap<Integer,Integer> hs = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                count++;
                hs.put(count,i);
            }
        }
        for(int i=0;i<n;i++){
            if(hs.containsKey(queries[i]))ans[i]=hs.get(queries[i]);
            else ans[i]=-1;
        }
        return ans;
    }
}
