class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while(left < right){
            int ht = Math.min(height[left], height[right]);
            maxWater = Math.max((right - left) * ht, maxWater);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
}