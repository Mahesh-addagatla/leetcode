class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int row=0,col=m-1;
        while(row<n && col>=0){
            if(mat[row][col]==target){
                return true;
            }
            else if(mat[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
