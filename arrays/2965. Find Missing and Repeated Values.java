class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long sum_n = (long) n*n*(n*n+1)/2;
        long sum_square_n = (long) n*n*(n*n+1)*(2*n*n+1)/6;
        long grid_sum = 0, grid_sum_squares = 0;
        for(int[] row : grid){
            for(int num : row){
                grid_sum += (long)num;
                grid_sum_squares += (long)num*num;
            }
        }

        long dif_sum_n = sum_n - grid_sum;
        long dif_square = sum_square_n - grid_sum_squares;
        long sum_ab = dif_square/dif_sum_n;

        int a = (int)((dif_sum_n+sum_ab)/2);
        int b = (int)((sum_ab - dif_sum_n)/2);

        return new int[]{b,a};

    }
}
