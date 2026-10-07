class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1){
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        q.add(0);
        parent[0] = -1;
        visited[0] = true;
        int count = 1;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i : adjList.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    parent[i] = node;
                    q.add(i);
                    count++;
                }
                else{
                   if(parent[node] == i)
                        continue;
                    else
                        return false;
                }
            }
        }

        return count == n;
    }
}