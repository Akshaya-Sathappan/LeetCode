class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        int result = 0;

        for(int e = 0; e < isConnected.length; e++){
            if(visited[e] == false){
                bfs(visited, e, isConnected);
                result++;
            }
        }
        return result;
    }

    public void bfs(boolean[] visited, int e, int[][] isConnected) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(e);
        visited[e] = true;

        while(!q.isEmpty()){
            int element = q.poll();

            for(int l = 0; l < isConnected[element].length; l++){
                int con = isConnected[element][l];
                if(con == 1 && !visited[l]){
                    q.add(l);
                    visited[l] = true;
                }
            }
        }
    }
}