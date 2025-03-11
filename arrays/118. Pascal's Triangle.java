class Solution {
    public List<List<Integer>> generate(int numRows) {
        int row = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while(row < numRows){
            List<Integer> a = new ArrayList<>();
            for(int i=0;i<=row;i++){
                if(i == 0 || i == row){
                    a.add(1);
                }
                else{
                    a.add(ans.get(row-1).get(i-1)+ans.get(row-1).get(i));
                }
            }
            ans.add(a);
            row++;
        }
        return ans;
    }
}
