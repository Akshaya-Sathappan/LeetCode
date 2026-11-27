class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[graph.length];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < graph.length; i++){
            adjList.add(new ArrayList<>());
        }

        for(int j = 0; j < graph.length; j++){
            for(int k = 0; k < graph[j].length; k++){
                adjList.get(graph[j][k]).add(j);
                indegree[j]++;
            }
        }

        for(int l = 0; l < indegree.length; l++){
            if(indegree[l] == 0){
                q.add(l);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);

            for(int nei : adjList.get(node)){
                indegree[nei]--;

                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        
        Collections.sort(safeNodes);

        return safeNodes;
    }
}