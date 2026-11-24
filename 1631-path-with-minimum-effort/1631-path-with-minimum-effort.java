class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];

        for(int[] arr : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] {0, 0, 0});
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while(!pq.isEmpty()){
            int[] a = pq.poll();
            int diff = a[0];
            int r = a[1];
            int c = a[2];

            if(r == rows - 1 && c == cols - 1) return diff;

            if(dist[r][c] < diff) continue;

            for(int i = 0; i < 4; i++){
                int newR = r + directions[i][0];
                int newC = c + directions[i][1];

                if(newR >= 0 && newC >= 0 && newR < rows && newC < cols){
                    int newEffort = Math.max(diff, Math.abs(heights[r][c] - heights[newR][newC]));
                    if(newEffort < dist[newR][newC]){
                        dist[newR][newC] = newEffort;
                        pq.offer(new int[] {newEffort, newR, newC});
                    }
                }
            }
        }
        return 0;
    }
}