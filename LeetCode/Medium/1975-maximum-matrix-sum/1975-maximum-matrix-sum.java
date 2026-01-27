class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int negCount = 0;
        long sum = 0;
        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < 0){
                    negCount++;
                }
                mini = Math.min(mini, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }

        if(negCount % 2 != 0){
            return sum - (2 * mini);
        }

        return sum;
    }
}