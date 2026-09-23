class Solution {
    public int numIslands(char[][] grid) {
        int nRows = grid.length;
        int nColumns = grid[0].length;
        int count = 0;

        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        grid[r][c] = '0';

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int[] elem = q.poll();

            for(int[] dir : directions){
                int nr = elem[0] + dir[0];
                int nc = elem[1] + dir[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
