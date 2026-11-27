class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int n = q.poll();

            for(int j = 0; j < rooms.get(n).size(); j++){
                int m = rooms.get(n).get(j);
                if(!visited[m]){
                    q.add(m);
                    visited[m] = true;
                }
            }
        }

        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }
}