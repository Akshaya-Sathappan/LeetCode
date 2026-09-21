class Solution {
    public int islandPerimeter(int[][] grid) {
        int noOfColumns = grid[0].length;
        int noOfRows = grid.length;
        int result = 0;

        for(int i = 0; i < noOfRows; i++){
            for(int j = 0; j < noOfColumns; j++){
                if(grid[i][j] == 1){
                    result += ((i - 1) < 0 || grid[i - 1][j] == 0) ? 1 : 0;
                    result += ((i + 1) >= noOfRows || grid[i + 1][j] == 0) ? 1 : 0;
                    result += ((j - 1) < 0 || grid[i][j - 1] == 0) ? 1 : 0;
                    result += ((j + 1) >= noOfColumns || grid[i][j + 1] == 0) ? 1 : 0;
                }
            }
        }

        return result;
    }
}