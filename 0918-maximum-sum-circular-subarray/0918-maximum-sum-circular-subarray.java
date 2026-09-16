class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSubarraySum = 0;
        int minSubarraySum = Integer.MAX_VALUE;
        int maxSubarraySum = Integer.MIN_VALUE;
        int currentMinSum = 0;
        int currentMaxSum = 0;

        for(int n : nums){
            totalSubarraySum += n;

            currentMinSum = Math.min(n, currentMinSum + n);
            minSubarraySum = Math.min(minSubarraySum, currentMinSum);

            currentMaxSum = Math.max(n, currentMaxSum + n);
            maxSubarraySum = Math.max(maxSubarraySum, currentMaxSum);
        }

        if(totalSubarraySum == minSubarraySum){
            return maxSubarraySum;
        }

        return Math.max(maxSubarraySum, totalSubarraySum - minSubarraySum);
    }
}