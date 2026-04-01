class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for(int left = 0; left < nums.length; left++){
            sum += nums[left];
            while(sum >= target){
                minLen = Math.min(minLen, left - right + 1);
                sum -= nums[right];
                right++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}