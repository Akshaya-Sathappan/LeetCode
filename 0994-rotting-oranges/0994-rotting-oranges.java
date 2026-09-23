class Solution {

    Queue<int[]> q = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int nRows = grid.length;
        int nColumns = grid[0].length;
        int freshCount = 0;
        
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        
        return bfs(grid, freshCount);
    }

    public int bfs(int[][] grid, int freshCount){
        int minMinutes = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] node = q.poll();

                for(int[] dir : directions){
                    int nr = node[0] + dir[0];
                    int nc = node[1] + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                        q.add(new int[] {nr, nc});
                        grid[nr][nc] = 2;
                        freshCount --;
                    }
                }
            }

            if(!q.isEmpty())
                minMinutes++;
        }

        if(freshCount != 0)
            return -1;
            
        return minMinutes;
    }
}