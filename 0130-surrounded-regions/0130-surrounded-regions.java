class Solution {
    public void solve(char[][] board) {
        int nRows = board.length;
        int nCols = board[0].length;

        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(board[i][j] == 'O'){
                    bfs(board, i, j);
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j){
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> toReplace = new LinkedList<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;
        toReplace.add(new int[] {i, j});
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean boundary = false;

        while(!q.isEmpty()){
            int[] node = q.poll();
            if(node[0] == 0 || node[0] == board.length - 1 || node[1] == 0 ||node[1] == board[0].length - 1 ){
                boundary = true;
            }

            for(int[] dir : directions){
                int nr = node[0] + dir[0];
                int nc = node[1] + dir[1];
        
                if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O' && !visited[nr][nc]){
                    q.add(new int[] {nr, nc});
                    toReplace.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        if(boundary == false){
            while(!toReplace.isEmpty()){
                int[] elem = toReplace.poll();
                board[elem[0]][elem[1]] = 'X';
            }
        }
    }
}