class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int i = 1;
        int[] prev = intervals[0];

        while(i < intervals.length){
            if(prev[1] < intervals[i][0]){
                result.add(prev);
                prev = intervals[i];
                i++;
            }

            else{
                while(i < intervals.length && prev[1] >= intervals[i][0]){
                    prev[0] = Math.min(intervals[i][0], prev[0]);
                    prev[1] = Math.max(intervals[i][1], prev[1]);
                    i++;
                }
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][2]);
    }
}