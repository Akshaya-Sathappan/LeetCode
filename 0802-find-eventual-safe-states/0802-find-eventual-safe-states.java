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

        boolean[] safeNodes = new boolean[graph.length];

        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes[node] = true;;

            for(int nei : adjList.get(node)){
                indegree[nei]--;

                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();

        for(int a = 0; a < safeNodes.length; a++){
            if(safeNodes[a] == true){
                result.add(a);
            }
        }

        return result;
    }
}