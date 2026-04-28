class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        int sum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            if(right - left + 1 == k){
                maxAvg = Math.max(maxAvg,(double) sum/k);
                sum -= nums[left];
                left++;
            }
        }
        return maxAvg;
    }
}