class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if((j>0 && grid[i][j-1]==0)|| j==0){
                        count++;
                    }
                    if((i>0 && grid[i-1][j]==0)|| i==0){
                        count++;
                    }
                    if((j<m-1 && grid[i][j+1]==0)|| j==m-1){
                        count++;
                    }
                    if((i<n-1 && grid[i+1][j]==0)|| i==n-1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
