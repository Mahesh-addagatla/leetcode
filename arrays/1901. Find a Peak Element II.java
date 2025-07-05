//1901. Find a Peak Element II
class Solution {
    public int maxElem(int[][] mat,int n,int m,int col){
        int maxi = Integer.MIN_VALUE;
        int ind = -1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>maxi){
                maxi=mat[i][col];
                ind = i;
            }
        }
        return ind;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low =0,high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = maxElem(mat,n,m,mid);
            int left = mid>0?mat[row][mid-1] : -1;
            int right = mid<m-1 ? mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row, mid};
            }
            else if(mat[row][mid]<left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
