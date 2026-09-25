class Solution {
    static final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        int nRows = rooms.length;
        int nCols = rooms[0].length;

        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(rooms[i][j] == 0){
                    bfs(rooms, i, j);
                }
            }
        }
    }

    public void bfs(int[][] rooms, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        int distance = 0;
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int[] node = q.poll();
            distance = rooms[node[0]][node[1]];

            for(int[] dir : directions){
                int nr = dir[0] + node[0];
                int nc = dir[1] + node[1];

                if(nr >= 0 && nc >= 0 && nr < rooms.length && nc < rooms[0].length){
                    if(rooms[nr][nc] == INF){
                        q.add(new int[] {nr, nc});
                        rooms[nr][nc] = distance + 1;
                    }
                    else if(rooms[nr][nc] != 0){
                        if(rooms[nr][nc] > distance + 1){
                            rooms[nr][nc] = distance + 1;
                            q.add(new int[] {nr,nc});
                        }
                    }
                }
            }
        }
    }
}