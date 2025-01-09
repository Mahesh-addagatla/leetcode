class Solution {
    public static boolean isValid(int row,int col,char c,char[][] board){
        for(int i=0;i<9;i++){
            if(board[row][i]==c)return false;
            if(board[i][col]==c)return false;
            if(board[3*(row/3)+ i/3][3*(col/3)+ i%3]==c)return false;
        }
        return true;
    }
    public static boolean SolveBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(i,j,c,board)){
                            board[i][j]=c;
                            if(SolveBoard(board)){
                                return true;
                            }else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        SolveBoard(board);
    }
}
