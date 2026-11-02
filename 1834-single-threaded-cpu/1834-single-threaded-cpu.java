class Solution {
    public int[] getOrder(int[][] tasks) {
        
        PriorityQueue<int[]> nextTask = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));

        int[][] sortedTasks = new int[tasks.length][3];

        for(int i = 0; i < tasks.length; i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]);

        int curTime = 0;
        int[] result = new int[tasks.length];
        int ansIndex = 0;
        int taskIndex = 0;

        while(taskIndex < tasks.length || !nextTask.isEmpty()){
            if(nextTask.isEmpty() && curTime < sortedTasks[taskIndex][0]){
                curTime = sortedTasks[taskIndex][0];
            }

            while(taskIndex < tasks.length && sortedTasks[taskIndex][0] <= curTime){

                nextTask.add(sortedTasks[taskIndex]);
                taskIndex++;
            }

            int processTime = nextTask.peek()[1];
            int index = nextTask.peek()[2];
            curTime += processTime;
            nextTask.poll();

            result[ansIndex++] = index;
        }

        return result;
    }
}