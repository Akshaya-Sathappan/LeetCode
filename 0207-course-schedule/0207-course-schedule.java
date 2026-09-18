class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int course = arr[0];
            int prereq = arr[1];

            list.get(prereq).add(course);
            indegree[course]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int c = queue.poll();
            count++;

            for(int j : list.get(c)){
                indegree[j]--;

                if(indegree[j] == 0){
                    queue.offer(j);
                }
            }
        }

        return count == numCourses;
    }
}