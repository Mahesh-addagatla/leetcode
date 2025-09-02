class Solution {
    public static void com(int k,int tar,int num,ArrayList<Integer> cur,List<List<Integer>> ans){
        if(cur.size()==k){
            if(tar==0){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int i=num;i<=9;i++){
            if(cur.contains(i))continue;
            cur.add(i);
            com(k,tar-i,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        com(k,n,1,new ArrayList<Integer>(),ans);
        return ans;
    }
}
