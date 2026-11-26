class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] color = new int[graph.length];

        Arrays.fill(color, -1);

        for(int k = 0; k < graph.length; k++){
            
            if(color[k] != -1) continue;

            q.add(k);
            color[k] = 0;

            while(!q.isEmpty()){
                int i = q.poll();
                
                for(int j = 0; j < graph[i].length; j++){
                    int e = graph[i][j];

                    if(color[e] == -1){
                        if(color[i] == 0){
                            color[e] = 1;
                        }
                        else{
                            color[e] = 0;
                        }

                        q.add(e);
                    }

                    else{
                        if(color[e] != color[i]){
                            continue;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}