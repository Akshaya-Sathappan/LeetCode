class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        int len = edges.length;

        for(int i = 0; i <= len; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(bfs(list, u, v, len)){
                return edge;
            }
            list.get(u).add(v);
            list.get(v).add(u);
        }

        return new int[]{0, 0};
    }

    public boolean bfs(List<List<Integer>> list, int u, int v, int len){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[len + 1];

        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int nei : list.get(node)){
                if(nei == v){
                    return true;
                }
                if(!visited[nei]){
                    q.add(nei);
                    visited[nei] = true;
                }
            }
        }

        return false;
    }
}
