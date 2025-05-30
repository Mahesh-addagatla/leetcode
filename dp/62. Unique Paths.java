class Solution {
    public int f(int[][] dp,int row,int col){
        if(row==0 && col==0)return 1;
        if(row<0 || col<0)return 0;
        if(dp[row][col]!=-1)return dp[row][col];
        int up = f(dp,row-1,col);
        int left = f(dp,row,col-1);
        return dp[row][col] = up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)continue;
                else{
                    int up=0,left=0;
                    if(i>0)  up=dp[i-1][j];
                    if(j>0)  left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
