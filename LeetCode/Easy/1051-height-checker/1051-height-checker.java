class Solution {
    public int heightChecker(int[] heights) {
        int[] height = new int[heights.length];
        int count = 0;
        System.arraycopy(heights, 0,height , 0, heights.length);
        Arrays.sort(heights);
        for(int i=0; i<heights.length; i++){
            if(height[i]!=heights[i]){
                count ++;
            }
        }
        return count;
    }
}