class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i-1]==nums[i])continue;
            for(int j=i+1;j<n;j++){
                if(j!=i+1 && nums[j-1]==nums[j] )continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> a = (Arrays.asList(nums[i], nums[j], nums[k],nums[l]));
                        ans.add(a);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum>target){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}
