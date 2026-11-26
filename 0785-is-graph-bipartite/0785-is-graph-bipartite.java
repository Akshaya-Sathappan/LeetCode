class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                boolean result = bfs(graph, i, color);
                if(result == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int start, int[] color){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int e = q.poll();

            for(int j = 0; j < graph[e].length; j++){
                int adj = graph[e][j];

                if(color[adj] == -1){
                    color[adj] = 1 - color[e];
                    q.add(adj);
                }
                else if(color[adj] == color[e]){
                    return false;
                }
            }
        }
        return true;
    }
}
