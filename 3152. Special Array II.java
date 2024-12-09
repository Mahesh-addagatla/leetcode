// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//         int m=queries.length;
//         boolean[] ans= new boolean[m];
//         for(int i=0;i<m;i++){
//             int c=0;
//             for(int j=queries[i][0]+1;j<=queries[i][1];j++){
//                 if(nums[j-1]%2==nums[j]%2)break;
//                 else c++;
//             }
//             if(c==queries[i][1]-queries[i][0])ans[i]=true;
//             else ans[i]=false;    
//         }
//         return ans;
//     }
// }

class Solution{
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] cnta = new int[n];
        int c=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]%2!=nums[i]%2)c++;
            cnta[i]=c;
        }
        boolean[] ans= new boolean[m];
        for(int i=0;i<m;i++){
            ans[i]=false;
            if(cnta[queries[i][1]]-cnta[queries[i][0]]==queries[i][1]-queries[i][0]){
                ans[i]=true;
            }
        }
        return ans;
    }
}
