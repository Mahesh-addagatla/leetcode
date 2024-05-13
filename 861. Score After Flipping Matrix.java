class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=(int)Math.pow(2,n-1)*m;

        for(int j=1;j<n;j++){
            int samebits=0;
            for(int i=0;i<m;i++){
                if(grid[i][j]==grid[i][0]){
                    samebits++;
                }
            }
            int countone=samebits;
            int countzero=m-samebits;
            int one=Math.max(countone,countzero);
            ans=ans+(int)(Math.pow(2,n-j-1)*one);
        }
        return ans;
    }
}
