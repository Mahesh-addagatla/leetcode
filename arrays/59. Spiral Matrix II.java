class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int num = 1;
        int l=0,r=n-1,t=0,b=n-1;
        while(l<=r){
            for(int i=l;i<=r;i++){
                mat[t][i] = num++;
            }
            t++;
            for(int i=t;i<=b;i++){
                mat[i][r] = num++;
            }
            r--;
            for(int i=r;i>=l;i--){
                mat[b][i] = num++;
            }
            b--;
            for(int i=b;i>=t;i--){
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
}
