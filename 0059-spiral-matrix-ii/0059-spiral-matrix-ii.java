class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int[][] matrix = new int[n][n];
        int num = 1;

        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                matrix[top][i] = num;
                num++;
            }
            top++;

            for(int i = top; i <= bottom; i++){
                matrix[i][right] = num;
                num++;
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = num;
                    num++;
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return matrix;
    }
}