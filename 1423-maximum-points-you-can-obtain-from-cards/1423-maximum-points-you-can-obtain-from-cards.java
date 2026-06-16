class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int points : cardPoints){
            sum += points;
        }

        return sum - minSumContiguousSubArray(cardPoints, cardPoints.length - k);
    }

    private int minSumContiguousSubArray(int[] cardPoints, int k){
        int left = 0;
        int minSum = 0;
        int ans = Integer.MAX_VALUE;

        if(k == 0) return 0;

        for(int right = 0; right < cardPoints.length; right++){
            minSum += cardPoints[right];

            if(right - left + 1 > k){
                minSum -= cardPoints[left];
                left++;
            }

            if(right - left + 1 == k){
                ans = Math.min(ans, minSum);
            }
        }
        return ans;
    }
}