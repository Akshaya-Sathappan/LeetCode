class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(adjList, i, visited);
                count++;
            }
        }
        return count;
    }

    public void bfs(List<List<Integer>> adjList, int i, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int n : adjList.get(node)){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}