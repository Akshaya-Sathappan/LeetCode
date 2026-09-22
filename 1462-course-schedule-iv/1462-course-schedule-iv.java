class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Set<Integer>> list = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            list.add(new HashSet<>());
        }
        
        for(int[] arr : prerequisites){
            int prereq = arr[0];
            int course = arr[1];

            list.get(prereq).add(course);
            indegree[course]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int[] f = new int[numCourses];
        int k = 0;

        while(!q.isEmpty()){
            int a = q.poll();
            f[k++] = a;

            for(int u : list.get(a)){
                indegree[u]--;

                if(indegree[u] == 0){
                    q.add(u);
                }
            }
        }

        for(int i = numCourses - 1; i >= 0; i--){
            int t = f[i];
            List<Integer> neighbors = new ArrayList<>(list.get(t));
            for(int n : neighbors){
                list.get(t).addAll(list.get(n));
            }
        }

        List<Boolean> lis = new ArrayList<>();
        
        for(int[] qe : queries){
            if(list.get(qe[0]).contains(qe[1])){
                lis.add(true);
            }
            else{
                lis.add(false);
            }
        }
        return lis;
    }
}