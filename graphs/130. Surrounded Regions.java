class Solution {
    public static void dfs(char[][] board,int r,int c,int[][] vis,int m,int n,int[] drow,int[] dcol){
        vis[r][c] = 1;
        for(int i=0;i<4;i++){
            int dr = r+drow[i];
            int dc = c+dcol[i];
            if(dr>=0 && dr<m && dc>=0 && dc<n && board[dr][dc] == 'O' && vis[dr][dc]==0){
                dfs(board,dr,dc,vis,m,n,drow,dcol);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // int[][] ans = new int[m][n];
        int[][] vis = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,-1,0,1};
        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(board,0,i,vis,m,n,drow,dcol);
            }
            if(vis[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(board,m-1,i,vis,m,n,drow,dcol);
            }
        }

        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(board,i,0,vis,m,n,drow,dcol);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(board,i,n-1,vis,m,n,drow,dcol);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
