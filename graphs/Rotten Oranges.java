class Solution {
    public int orangesRotting(int[][] grid) {
        if( grid == null || grid.length==0)return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                    // vis[i][j] = 2;
                }
                if(grid[i][j]==1)cntFresh++;
            }
        }
        if(cntFresh==0)return 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0],c=cur[1],t=cur[2];
            tm=Math.max(tm,t);
            // System.out.println(r + "  " + c);
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&  grid[nrow][ncol]==1){
                    System.out.println("idhwugvy");
                    grid[nrow][ncol] = 2;
                    q.offer(new int[]{nrow,ncol,t+1});
                    cnt++;
                }
            }

        }
        System.out.println(cnt + "  " + cntFresh);
        if(cnt != cntFresh)return -1;

        return tm;

    }
}
