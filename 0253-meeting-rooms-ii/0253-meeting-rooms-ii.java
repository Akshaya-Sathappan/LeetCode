class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;

        if(len == 1) return 1;
        
        int[] startTimes = new int[len];
        int[] endTimes = new int[len];

        for(int i = 0; i < len; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int k = 0;
        int j = 0;
        int maxCount = 0;
        int count = 0;

        while(j < len && k < len){
            if(startTimes[j] < endTimes[k]){
                count++;
                j++;
            }
            else{
                count--;
                k++;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}