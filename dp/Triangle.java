class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] prev = new int[n];
        for(int i=0;i<n;i++){
            prev[i] = triangle.get(m-1).get(i);
        }
        for(int i=m-2;i>=0;i--){
            int[] cur = new int[n];
            for(int j=i;j>=0;j--){
                int d = triangle.get(i).get(j) + prev[j];
                int dg = triangle.get(i).get(j) + prev[j+1];
                cur[j] = Math.min(d,dg);
            }
            prev = cur;
        }
        return prev[0];
    }
}
