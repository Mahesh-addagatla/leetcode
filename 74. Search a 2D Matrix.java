class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length , m=matrix[0].length;
        int high = n*m-1,low=0;
        while(low<=high){
            int mid = (low+high)/2;
            int r=mid/m,c=mid%m;
            if(matrix[r][c]==target)return true;
            else if(matrix[r][c]>target)high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}
