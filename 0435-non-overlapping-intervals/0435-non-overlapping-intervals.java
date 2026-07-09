class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int nonOverlapping = 1;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int currentEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(currentEnd <= intervals[i][0]){
                currentEnd = intervals[i][1];
                nonOverlapping++;
            }
        }
 
        return intervals.length - nonOverlapping;
    }
}