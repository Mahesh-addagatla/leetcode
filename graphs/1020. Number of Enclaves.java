class Solution {
    public static void dfs(int[][] grid,int r,int c,int[][] vis,int[] drow,int[] dcol){
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] = 1;
        for(int i=0;i<4;i++){
            int dr = r+drow[i];
            int dc = c+dcol[i];
            if(dr>=0 && dr<m && dc>=0 && dc<n && grid[dr][dc] == 1 && vis[dr][dc]==0){
                dfs(grid,dr,dc,vis,drow,dcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};
        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && grid[0][i]==1){
                dfs(grid,0,i,vis,drow,dcol);
            }
            if(vis[m-1][i]==0 && grid[m-1][i]==1){
                dfs(grid,m-1,i,vis,drow,dcol);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(grid,i,0,vis,drow,dcol);
            }
            if(vis[i][n-1]==0 && grid[i][n-1]==1){
                dfs(grid,i,n-1,vis,drow,dcol);
            }
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    c++;
                }
            }
        }
        return c;
    }
}
