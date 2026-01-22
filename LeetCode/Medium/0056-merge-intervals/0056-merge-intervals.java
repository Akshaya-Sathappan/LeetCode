class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int n = intervals.length - 1;
        int[] prev = intervals[0];

        for(int i = 1; i <= n; i++){
            if(prev[1] < intervals[i][0]){
                list.add(prev);
                prev = intervals[i];
            }
            else{
                int startingPt = prev[0];
                int endingPt = prev[1];
                while(i <= n && endingPt >= intervals[i][0]){
                    endingPt = Math.max(endingPt, intervals[i][1]);
                    i++;
                }
                prev = new int[]{startingPt, endingPt}; 
                i = i - 1;
            }
        }
        list.add(prev);

        int[][] array = list.toArray(new int[list.size()][2]);

        return array;
    }
}