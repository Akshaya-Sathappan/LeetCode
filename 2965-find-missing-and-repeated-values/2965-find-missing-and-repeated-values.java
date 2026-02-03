class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int N = grid.length * grid.length;
        long sum = 0;
        long sqSum = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                sum += (long)grid[i][j];
                sqSum += (long)(grid[i][j] * grid[i][j]);
            }    
        }

        long acSum = (long)(N * (N + 1))/2;
        long acSqSum = (long) (N * (N + 1) * (2L * N + 1))/6;

        long A = sum - acSum;
        long B = (sqSum - acSqSum) / A;

        int r = (int)((A + B)/2);
        int m = (int) (B - r);

        return new int[]{r, m};
    }
}