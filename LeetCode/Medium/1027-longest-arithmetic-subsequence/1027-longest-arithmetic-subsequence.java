class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                maxi = Math.max(maxi, dp[i].get(diff));
            }
        }
        return maxi;
    }
}