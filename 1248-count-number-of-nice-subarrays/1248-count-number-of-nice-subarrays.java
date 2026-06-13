class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return niceSubarrays(nums, k) - niceSubarrays(nums, k - 1);
    }

    public int niceSubarrays(int[] nums, int k){
        int left = 0;
        int count = 0;
        int noOfOdds = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 != 0){
                noOfOdds++;
            }

            while(noOfOdds > k){
                if(nums[left] % 2 != 0){
                    noOfOdds--;
                }
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}