class Solution {
    public static boolean isSafe(int row,int col,char[][] board,int n){
        int duprow=row;
        int dupcol=col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(row<n && col>=0){
            if(board[row][col]=='Q')return false;
            row++;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(col>=0){
            if(board[row][col]=='Q')return false;
            col--;
        }
        return true;
    }
    public static void saveBoard(char[][] board, List<List<String>> ans,int n){
        String row="";
        List<String> boards = new ArrayList<>();
        for(int i=0;i<n;i++){
            row="";
            for(int j=0;j<n;j++){
                if(board[i][j]=='Q')row+='Q';
                else row+='.';
            }
            boards.add(row);
        }
        ans.add(boards);
    }
    public static void solve(int col,char[][] board,List<List<String>> ans,int n){
        if(col==n){
            saveBoard(board,ans,n);
            return;
        }
        for(int row = 0;row<n;row++){
            if (isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        solve(0,board,ans,n);
        return ans;
    }
}
