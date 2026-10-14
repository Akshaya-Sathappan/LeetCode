class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> qP = new LinkedList<>();
        Queue<int[]> qA = new LinkedList<>();
        int noOfRows = heights.length;
        boolean[][] visitedP = new boolean[noOfRows][heights[0].length];
        boolean[][] visitedA = new boolean[noOfRows][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < noOfRows; i++){
            qP.add(new int[] {i, 0});
            visitedP[i][0] = true;
            qA.add(new int[] {i, heights[0].length - 1});
            visitedA[i][heights[0].length - 1] = true;
        }

        for(int j = 0; j < heights[0].length; j++){
            qP.add(new int[] {0, j});
            visitedP[0][j] = true;
            qA.add(new int[] {noOfRows - 1, j});
            visitedA[noOfRows - 1][j] = true;
        }

        bfs(qP, visitedP, heights);
        bfs(qA, visitedA, heights);

        for(int i = 0; i < noOfRows; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(visitedP[i][j] && visitedA[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public void bfs(Queue<int[]> q, boolean[][] visited, int[][] heights){
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] dir : directions){
                int nr = dir[0] + node[0];
                int nc = dir[1] + node[1];
                if(nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !visited[nr][nc] && heights[node[0]][node[1]] <= heights[nr][nc]){
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}