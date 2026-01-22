class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        if(prices.length > 1){
            dp[1][0] = Math.max(prices[1] + dp[0][1], dp[0][0]);
            dp[1][1] = Math.max(-prices[1], dp[0][1]);
            for(int i = 2; i < prices.length; i++){
                dp[i][0] = Math.max(prices[i] + dp[i-1][1], dp[i-1][0]);
                dp[i][1] = Math.max(-prices[i] + dp[i-2][0], dp[i-1][1]);
            }
        }    
        return dp[prices.length-1][0];
    }
}