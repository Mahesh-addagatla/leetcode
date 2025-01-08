class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        subsetWithDup(0,nums,num,ans);
        return ans;
    }
    public static void subsetWithDup(int offset,int[] nums ,List<Integer> num, List<List<Integer>> ans){
        ans.add(new ArrayList<>(num));
        for(int i=offset;i<nums.length;i++){
            if(i!=offset && nums[i]==nums[i-1]) continue;
            num.add(nums[i]);
            subsetWithDup(i+1,nums,num,ans);
            num.remove(num.size()-1);
        }
    }
}
