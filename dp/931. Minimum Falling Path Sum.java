class Solution {
    public int f(int[][] matrix, int i, int j, int[][] dp) {
        if (j < 0 || j >= matrix[0].length)
            return (int) 1e9;

        if (i == 0)
            return matrix[0][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = f(matrix, i - 1, j, dp);
        int left = f(matrix, i - 1, j - 1, dp);
        int right = f(matrix, i - 1, j + 1, dp);
        return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] cur = new int[m];
            for (int j = 0; j < m; j++) {
                int up = prev[j];
                int left = j > 0 ? prev[j - 1] : (int) 1e9;
                int right = j < n - 1 ? prev[j + 1] : (int) 1e9;
                cur[j] =  matrix[i][j] + Math.min(up, Math.min(left, right));
            }
            prev = cur;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min = Math.min(min,prev[i]);
        }
        return min;
    }
}
