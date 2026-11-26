class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <= isConnected.length; i++){
            adjList.add(new ArrayList<>());
        }

        for(int j = 0; j < isConnected.length; j++){
            for(int k = 0; k < isConnected[j].length; k++){
                if(isConnected[j][k] == 1){
                    adjList.get(j).add(k);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];

        int result = 0;

        for(int e = 0; e < isConnected.length; e++){
            if(visited[e] == false){
                bfs(visited, e, adjList);
                result++;
            }
        }
        return result;
    }

    public void bfs(boolean[] visited, int e, List<List<Integer>> adjList){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(e);
        visited[e] = true;

        while(!q.isEmpty()){
            int element = q.poll();

            for(int l = 0; l < adjList.get(element).size(); l++){
                int nei = adjList.get(element).get(l);
                if(!visited[nei]){
                    q.add(nei);
                    visited[nei] = true;
                }
            }
        }
    }
}