class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dis = new int[n][m];
        int[][] vis = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j] = 1;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,-1,0,1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0],c=cur[1];
            int d = cur[2];
            dis[r][c] = d;
            for(int i =0;i<4;i++){
                int dx = r+drow[i],dy = c+dcol[i];
                if(dx>=0 && dx<n && dy>=0 && dy<m && vis[dx][dy]==0){
                    vis[dx][dy]=1;
                    dis[dx][dy] = d+1;
                    q.offer(new int[]{dx,dy,d+1});
                }
            }
        }
        return dis;
    }
}
