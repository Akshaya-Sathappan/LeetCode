class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int availableCapacity = capacity;
        PriorityQueue<int[]> fromQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> toQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int[] trip : trips){
            fromQueue.offer(new int[] {trip[1], trip[0]});
            toQueue.offer(new int[] {trip[2], trip[0]});
        }

        int curLocation = 0;

        while(!fromQueue.isEmpty() && !toQueue.isEmpty()){
            curLocation = fromQueue.peek()[0];
            while(curLocation >= toQueue.peek()[0]){
                availableCapacity += toQueue.poll()[1];
            }

            availableCapacity -= fromQueue.poll()[1];
            
            if(availableCapacity < 0){
                return false;
            }
        }

        return true;
    }
}