class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, res, curr);
        return res;
    }

    void helper(int index, int[] nums, int target, List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > target)
                break;
            curr.add(nums[i]);
            helper(i + 1, nums, target - nums[i], res, curr);
            curr.remove(curr.size() - 1);
        }
        // helper(index+1,nums,target,res,curr);
    }
}