class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(0,candidates,target,res,curr);
        return res;
    }

    void helper(int index , int[] nums, int target , List<List<Integer>> res, List<Integer> curr) {
        if(index==nums.length) {
            if(target==0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if(nums[index] <= target) {
            curr.add(nums[index]);
            helper(index, nums, target-nums[index], res, curr);
            curr.remove(curr.size()-1);
        }
        helper(index+1,nums,target,res,curr);
    }
}
