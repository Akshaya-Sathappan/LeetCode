class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int nRows = grid.length;
        int nColumns = grid[0].length;
        int area = 0;
        int maxArea = 0;

        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                if(grid[i][j] == 1){
                    area = helper(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    public int helper(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;

        area += helper(grid, i + 1, j);
        area += helper(grid, i - 1, j);
        area += helper(grid, i, j + 1);
        area += helper(grid, i, j - 1);

        return area;
    }
}
