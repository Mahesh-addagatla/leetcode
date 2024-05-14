class Solution {
    int maxGold=0;
    int[] row={1,-1,0,0};
    int[] column={0,0,-1,1};
    public int dfs(int[][] grid,int x,int y,int n,int m){
        if(x<0||x>=n||y<0||y>=m||grid[x][y]==0)return 0;
        int cur=grid[x][y];
        grid[x][y]=0;
        int local=cur;
        for(int i=0;i<4;i++){
            int newX=x+row[i];
            int newY=y+column[i];
            local=Math.max(local,cur+dfs(grid,newX,newY,n,m));

        }
        grid[x][y]=cur;
        return local;
    }
    public int getMaximumGold(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    maxGold=Math.max(maxGold,dfs(grid,i,j,n,m));
                }
            }
        }
        return maxGold;
    }
}
